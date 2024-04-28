import javax.swing.*;
import java.awt.*;

public class FrontEnd extends JFrame {
    // Instance Variables
    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 1000;
    public static int SCREEN_XOFFSET = 100;
    public static int SCREEN_YOFFSET = 100;
    private MathFunction f;
    double dx;
    double x;
    double y;
    double x1;
    double y1;
    int originX;
    int originY;


    public FrontEnd() {
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Graph ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.dx = 0.0001;
        this.originX = SCREEN_XOFFSET;
        this.originY = SCREEN_HEIGHT - SCREEN_YOFFSET;
    }


    // Paints a function on the front end
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.drawRect(0,0,SCREEN_HEIGHT,SCREEN_WIDTH);
        g.fillRect(0,0,SCREEN_HEIGHT,SCREEN_WIDTH);
        g.setColor(Color.BLACK);
        // Drawing Y-axis
        g.drawLine(SCREEN_XOFFSET,SCREEN_YOFFSET,SCREEN_XOFFSET, SCREEN_HEIGHT - SCREEN_YOFFSET);
        g.drawString("Y - axis", SCREEN_XOFFSET / 2,SCREEN_YOFFSET);

        // Drawing X-axis
        g.drawLine(SCREEN_XOFFSET,SCREEN_HEIGHT - SCREEN_YOFFSET,SCREEN_WIDTH - SCREEN_XOFFSET, SCREEN_HEIGHT - SCREEN_YOFFSET);
        g.drawString("X - axis", SCREEN_WIDTH - SCREEN_XOFFSET, SCREEN_HEIGHT - SCREEN_YOFFSET);
        if(f != null)
        {
            for(int j = 0; j < 2; j++)
            {
                x = 0;
                if(j == 0)
                {
                    g.setColor(Color.BLACK);
                    // Drawing function
                    System.out.println("Drawing " + f.getStringF());
                    y = f.calcFunction(x);
                }
                else if(j == 1)
                {
                    // Drawing derivative
                    g.setColor(Color.RED);
                    // Drawing function
                    System.out.println("Drawing derivative of " + f.getStringF());
                    y = f.getDerivative(x);
                }
                for(int i = 0; i < Integer.MAX_VALUE; i++) {
                    x1 = x + dx;
                    if(j == 0)
                    {
                        y1 = f.calcFunction(x1);
                    }
                    else if(j == 1)
                    {
                        y1 = f.getDerivative(x1);
                    }
                    g.drawLine(convertMathXToGraph(x), convertMathYToGraph(y), convertMathXToGraph(x1), convertMathYToGraph(y1));
                    x = x1;
                    y = y1;
                    if(x >= SCREEN_WIDTH || y <= 0)
                    {
                        break;
                    }
                }
            }
            if(f.isDisplayArea())
            {
                paintArea(g);
            }
        }
    }

    public void paintArea(Graphics g)
    {
        if(f == null)
        {
            return;
        }
        int reimannSum = 0;
        g.setColor(Color.BLUE);
        int x2;
        int dx = SCREEN_WIDTH / 100;
        for(int i = 0; i < 100; i++)
        {
            x2 = i * dx;
            g.drawRect(convertMathXToGraph(x2), convertMathYToGraph(f.calcFunction(x2)), dx, (int)f.calcFunction(x2));
            g.setColor(Color.ORANGE);
            g.fillRect(convertMathXToGraph(x2), convertMathYToGraph(f.calcFunction(x2)), dx, (int)f.calcFunction(x2));
        }
    }

    public int convertMathXToGraph(double xValue)
    {
        return (int) (originX + (xValue));
    }

    public int convertMathYToGraph(double yValue)
    {
        return (int)(originY - (yValue));
    }

    public MathFunction getF() {
        return f;
    }

    public void setF(MathFunction f) {
        this.f = f;
    }

    public static int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public static int getScreenXoffset() {
        return SCREEN_XOFFSET;
    }

    public static int getScreenYoffset() {
        return SCREEN_YOFFSET;
    }
}
