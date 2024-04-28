/*
Name: Agastya-Brahmbhatt
Date: 4/27/2024
CS2 Final Project: Graphs
 */

import java.awt.*;

public class MathFunction{
    // Instance Variables
    private String stringF;
    private FrontEnd window;

    private boolean displayArea = false;

    private double startX, endX, dx;
    private double inputX;

    // Constructor
    public MathFunction(String fStr, FrontEnd window) {
        this.stringF = fStr;
        this.window = window;
        this.startX = 0;
        this.endX = window.getScreenHeight() - window.getScreenYoffset();
        this.dx = 10;
    }
    public MathFunction(FrontEnd window) {
        stringF = "x"; this.startX = 0; this.endX = 1000; this.dx = 10;
        this.window = window;
        this.endX = window.getScreenHeight() - window.getScreenYoffset();
    }

    // Default Constructor
    public MathFunction()
    {
        stringF = "x"; this.startX = 0; this.endX = 1000; this.dx = 0.01;
        window = null;
    }

    public double getInputX() {
        return inputX;
    }

    public void setInputX(double inputX) {
        this.inputX = inputX;
    }

    public FrontEnd getWindow() {
        return window;
    }

    public void setWindow(FrontEnd window) {
        this.window = window;
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
            return (window.getScreenHeight() / 3)* Math.sin(x/100);
        }
        else if(stringF.equals("cosx"))
        {
            return (window.getScreenHeight() / 3) * Math.cos(x/100);
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

    public void drawXAxis(Graphics g)
    {
        System.out.println("Drawing X axis");
        if(window == null || g == null)
        {
            System.out.println("Drawing X axis RETURN NULL");
            return;
        }
        g.setColor(Color.BLACK);
        g.drawLine(window.getScreenXoffset(),window.getOriginY(),window.getScreenWidth() - window.getScreenXoffset(), window.getOriginY());
        g.drawString("X - axis", window.getScreenXoffset()/2, window.getOriginY());
    }

    public void drawUnits(Graphics g)
    {
        int xVal;
        for(int i = 0; i < 100; i++)
        {
            xVal = i * (window.getWidth() / 100);
            g.drawLine(xVal, (window.getOriginY() - 5), xVal, window.getOriginY() + 5);
        }
        int yVal;
        for(int i = 0; i < 100; i++)
        {
            yVal = i * (window.getHeight() / 100);
            g.drawLine(window.getOriginX() - 5, yVal, window.getOriginX() + 5, yVal);
        }
        // Telling user the unit increments
        g.drawString("Unit: Window Height / 100 ", 15, 85);

        // Key for which graph corresponds to what
        g.setColor(Color.GREEN);
        g.drawString("Function",30, 115);
        g.fillRect(15, 105, 10, 10);
        g.setColor(Color.RED);
        g.drawString("Derivative",30, 135);
        g.fillRect(15, 125, 10, 10);
    }


    public void drawYAxis(Graphics g)
    {
        System.out.println("Drawing Y axis");
        if(window == null || g == null)
        {
            if(window == null)
                System.out.println("Drawing Yaxis Window null");
            else
                System.out.println("Drawing Yaxis graphics null");
            return;
        }
        g.setColor(Color.BLACK);
        g.drawLine(window.getOriginX(),window.getScreenYoffset(), window.getOriginX(), window.getScreenHeight() - window.getScreenYoffset());
        g.drawString("Y - axis", window.getOriginX()-20,window.getScreenYoffset());
    }

    public void paintFunction(Graphics g)
    {
        if(g == null)
        {
            return;
        }
        double x, x1, y, y1;
        g.setColor(Color.GREEN);
        // Drawing function
        System.out.println("Drawing " + getStringF());
        x = startX;
        y = calcFunction(x);
        for(int i = 0; i < Integer.MAX_VALUE; i++)
        {
            x1 = x + dx;
            y1 = calcFunction(x1);
            g.drawLine(convertMathXToGraph(x), convertMathYToGraph(y), convertMathXToGraph(x1), convertMathYToGraph(y1));
            x = x1;
            y = y1;
            if(x > endX)
            {
                break;
            }
        }
    }
    public void paintDerivative(Graphics g)
    {
        if(g == null)
        {
            return;
        }
        double x, x1, y, y1;
        g.setColor(Color.RED);
        // Drawing derivative of function
        System.out.println("Drawing derivative of " + getStringF());
        x = startX;
        y = getDerivative(x);
        for(int i = 0; i < Integer.MAX_VALUE; i++)
        {
            x1 = x + dx;
            y1 = getDerivative(x1);
            g.drawLine(convertMathXToGraph(x), convertMathYToGraph(y), convertMathXToGraph(x1), convertMathYToGraph(y1));
            x = x1;
            y = y1;
            if(x > endX)
            {
                break;
            }
        }
    }
    public void paintArea(Graphics g)
    {
        if(g == null)
        {
            return;
        }
        double x2;
        int reimannW = 10;
        for(int i = 0; i < 100; i++)
        {
            x2 = i * reimannW;
            g.setColor(Color.BLACK);
            g.drawRect(convertMathXToGraph(x2), convertMathYToGraph(calcFunction(x2)), reimannW, (int)calcFunction(x2));
            g.setColor(Color.ORANGE);
            g.fillRect(convertMathXToGraph(x2)+10, convertMathYToGraph(calcFunction(x2))-10, reimannW+10, (int)calcFunction(x2)-10);
        }
    }

    public int convertMathXToGraph(double xValue)
    {
        if(this.getStringF().equals("x") || this.getStringF().equals("sinx") || this.getStringF().equals("cosx"))
        {
            if(window == null)
            {
                return 0;
            }
            return (int) (window.getOriginX()+ (xValue));
        }
        else
        {
            if(window == null)
            {
                return 0;
            }
            return (int) (window.getOriginX()+ (xValue * 100));
        }

    }

    public int convertMathYToGraph(double yValue)
    {
        if(window == null)
        {
            return 0;
        }
        return (int)(window.getOriginY()- (yValue));
    }

    public double getEndX() {
        return endX;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }
}
