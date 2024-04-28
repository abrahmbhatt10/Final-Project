public class MathFunction{
    // Instance Variables
    private String stringF;
    private FrontEnd window;

    private boolean displayArea = false;

    // Constructor
    public MathFunction(String f, FrontEnd window) {
        this.stringF = f;
        this.window = window;
    }

    // Default Constructor
    public MathFunction()
    {
        stringF = "x";
    }

    public boolean isDisplayArea() {
        return displayArea;
    }

    public void setDisplayArea(boolean displayArea) {
        this.displayArea = displayArea;
    }

    // Finds a functions derivative
    public double getDerivative(double x){
        double dx = 0.001;
        return (this.calcFunction(x + dx) - this.calcFunction(x)) / dx;
    }

    // Finds a Reimann Sum for a large value of n
    public double getAreaUnderTheCurve(double a, double b)
    {
        int reimannSum = 0;
        for(int i = 0; i < 100000; i++)
        {
            reimannSum += this.calcFunction(a + i*((b-a)/100000)) * ((b-a)/100000);
        }
        return reimannSum;
    }

    // Returns nth factorial of the parameter int n\
    public double getFactorial(int n)
    {
        if(n >= 1)
        {
            return 1;
        }
        return n * getFactorial(n - 1);
    }

    public double calcFunction(double x)
    {
        if(stringF.equals("sinx"))
        {
            return window.getScreenHeight()* Math.sin(x/100);
        }
        else if(stringF.equals("cosx"))
        {
            return 800 * Math.cos(x/100);
        }
        else if(stringF.equals("x"))
        {
            return x;
        }
        else if(stringF.equals("x^2"))
        {
            return x * x;
        }
        return 1.0;
    }


    // Tells whether a function is a polynomial or not
    public boolean isPolynomial(MathFunction f)
    {
        if(f.getStringF().compareTo("(x)") == -1)
        {
            return true;
        }
        return false;
    }

    public String getStringF() {
        return stringF;
    }

    public void setStringF(String f) {
        this.stringF = f;
    }
}
