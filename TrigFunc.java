public class TrigFunc extends MathFunction{
     public TrigFunc(FrontEnd window) {
        super.setWindow(window);
    }

    public double getDerivative(double x){
        if(super.getStringF().equals("sinx"))
        {
            return Math.cos(x);
        }
        else if(super.getStringF().equals("cosx"))
        {
            return -1 * Math.sin(x);
        }
        return 0.0;
    }

    public double calcFunction(double x)
    {
        if(super.getStringF().equals("sinx"))
        {
            return Math.sin(x);
        }
        else if(super.getStringF().equals("cosx"))
        {
            return Math.cos(x);
        }
        return 0.0;
    }
    public int convertMathXToGraph(double xValue)
    {
        if(super.getWindow() == null)
        {
            return (int)xValue;
        }
        return (int) (super.getWindow().getOriginX()+ (xValue*super.getWindow().getScreenXoffset()));
    }
    public int convertMathYToGraph(double yValue)
    {
        if(super.getWindow() == null)
        {
            return (int)yValue;
        }
        return (int)((super.getWindow().getOriginY() - (yValue * (super.getWindow().getScreenHeight() / 3))));
    }
}
