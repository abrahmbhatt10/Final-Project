public class Calculator {
    private double a;
    private double b;
    private double x;
    private int n;
    private int power;
    private double c;
    double finalVal;

    public Calculator(double a, double b, double x, int n, int power, double c) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.n = n;
        this.power = power;
        this.c = c;
    }
    
    public double getDerivative(Function f, int x){
        double dx = 1 / Integer.MAX_VALUE;
        return (f.f(x + dx) - f.f(x)) / dx;
    }

    //Returns nth dervative
    /*public double getNthDerivative(Function f, int n, int x)
    {
        if(n == 0)
        {
            return finalVal;
        }
        else
        {
            n--;
            return getNthDerivative(getDerivative(f,x), n, x);
        }
    }
    */

    public double getAreaUnderTheCurve(Function f, int a, int b)
    {
        int reimannSum = 0;
        for(int i = 0; i < Integer.MAX_VALUE; i++)
        {
            reimannSum += f.f(a + i*((b-a)/n)) * ((b-a)/n);
        }
        return reimannSum;
    }

    /*
    public String getTaylorPolynomial(Function f, int x, int k)
    {
        int sum = 0;
        for (int n = 0; n < k; n++)
        {
            sum += (getNthDerivative(f, n, x)) / getFactorial(n) * (x - a) ^ n;
        }
        return sum;
    }
     */

    public double getFactorial(int n)
    {
        if(n >= 1)
        {
            return 1;
        }
        return n * getFactorial(n - 1);
    }

    /*
    public Function getLagrangeRemainderBound(Function f, int x, int a, int n)
    {
        double xOfM;
        double M = 1;
        return M /getFactorial(n+1) * (x - a) ^ (n+1);
    }
     */

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
