public class Calculator {
    private double a;
    private double b;
    private double x;
    private int n;
    private int power;
    private double c;

    public Calculator(double a, double b, double x, int n, int power, double c) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.n = n;
        this.power = power;
        this.c = c;
    }


    //Graphs a function on the front end
    public String graph(Function f){

    }


    public String getDerivative(Function f){
        if(f.getF().equals("sin(x)"))
        {
            return "cos(x)";
        }
        else if(f.getF().equals("cos(x)"))
        {
            return "-sin(x)";
        }
        else if(f.getF().equals("tan(x)"))
        {
            return "sec^2(x)"
        }
        if(f.isPolynomial(f))
        {
            // Returns derivative using power rule
            return (f.getF().substring(0,1)) + power + "x ^ " + (power - 1);
        }
        return null;
    }



    public double getAreaUnderTheCurve(Function f, a, b)
    {
        int reimannSum = 0;
        for(int i = 0; i < Integer.MAX_VALUE; i++)
        {
            reimannSum += (b - a)/n *
        }
    }

    public String getAntiDerivative(Function f){

    }

    public String getTaylorPolynomial(Function f)
    {

    }

    public double getReimannSum()
    {

    }

    public double getLagrangeRemainderBound()
    {

    }




    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
