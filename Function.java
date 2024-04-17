public class Function extends Calculator{
    private String f;

    public Function(double a, double b, double x, int n, int power, double c, String f) {
        super(a, b, x, n, power, c);
        this.f = f;
    }

    // Tells whether a function is a polynomial or not
    public boolean isPolynomial(Function f)
    {
        if(f.getF().compareTo("(x)") == -1)
        {
            return true;
        }
        return false;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }
}
