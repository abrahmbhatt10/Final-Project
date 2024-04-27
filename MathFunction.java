public class MathFunction extends Calculator{
    private String stringF;

    public MathFunction(double a, double b, double x, int n, int power, double c, String f) {
        super(a, b, x, n, power, c);
        this.stringF = f;
    }

    public MathFunction()
    {
        super(0,0,0,0,0,0);
        stringF = null;
    }


    public double calcFunction(double x)
    {
        if(stringF.equals("sinx"))
        {
            return Math.sin(x);
        }
        else if(stringF.equals("cosx"))
        {
            return Math.cos(x);
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
