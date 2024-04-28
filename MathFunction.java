/*
Name: Agastya-Brahmbhatt
Date: 4/27/2024
CS2 Final Project: Graphs
 */
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

    public String getStringF() {
        return stringF;
    }

    public void setStringF(String f) {
        this.stringF = f;
    }
}
