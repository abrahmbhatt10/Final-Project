/*
Name: Agastya-Brahmbhatt
Date: 4/27/2024
CS2 Final Project: Graphs
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontEnd extends JFrame implements ActionListener{
    // Instance Variables
    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 1000;
    public static int SCREEN_XOFFSET = 100;
    public static int SCREEN_YOFFSET = 100;

    private JButton bGoBack;
    GraphSelection gsWindow;
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
        this.setLayout(null);
        this.setVisible(true);
        this.dx = 0.0001;
        this.originX = (int) SCREEN_WIDTH/2;
        this.originY = (int) SCREEN_HEIGHT/2;
        JButton bGoBack = new JButton("Back To Graph Selection");
        bGoBack.setBounds(10,10,200,30);
        bGoBack.addActionListener(this);
        add(bGoBack);
    }

    public GraphSelection getGsWindow() {
        return gsWindow;
    }

    public void setGsWindow(GraphSelection gsWindow) {
        this.gsWindow = gsWindow;
    }

    // Paints a function on the front end
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.drawRect(0,0,SCREEN_HEIGHT,SCREEN_WIDTH);
        g.fillRect(0,0,SCREEN_HEIGHT,SCREEN_WIDTH);
        g.setColor(Color.BLACK);
        if(f == null)
        {
            return;
        }
        // Drawing Y-axis
        f.drawYAxis(g);

        // Drawing X-axis
        f.drawXAxis(g);

        //Drawing Units
        f.drawUnits(g);

        // Displaying function value and derivative value for x input value given by user
        g.setColor(Color.GREEN);
        g.drawString("For x = " + f.getInputX() + " function value = " + f.calcFunction(f.getInputX()),SCREEN_WIDTH - 250, SCREEN_YOFFSET);
        g.setColor(Color.RED);
        g.drawString("For x = " + f.getInputX() + " derivative value = " + f.getDerivative(f.getInputX()), SCREEN_WIDTH - 250, SCREEN_YOFFSET + 30);


        if(f.isDisplayArea())
        {
            f.paintArea(g);
        }
        for(int j = 0; j < 2; j++)
        {
                x = 0;
                if(j == 1)
                {
                    // Drawing derivative
                    f.paintDerivative(g);
                }
                else
                {
                        // Drawing function
                        f.paintFunction(g);
                }
        }
        g.setColor(Color.BLACK);
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

    public int getOriginX() {
        return originX;
    }

    public void setOriginX(int originX) {
        this.originX = originX;
    }

    public int getOriginY() {
        return originY;
    }

    public void setOriginY(int originY) {
        this.originY = originY;
    }

    public void actionPerformed(ActionEvent e){
        if(gsWindow == null)
        {
            gsWindow = new GraphSelection();
        }
        gsWindow.setVisible(true);
        setVisible(false);
    }
}
