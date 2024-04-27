import javax.swing.*;
import java.awt.*;

public class FrontEnd extends JFrame {
    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 800;
    public static int SCREEN_XOFFSET = 100;
    public static int SCREEN_YOFFSET = 100;
    private MathFunction f;
    double dx;
    double x;
    double y;
    double x1;
    double y1;
    int graphX;
    int graphY;


    public FrontEnd() {
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Graph ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.dx = 0.1;
        this.graphX = SCREEN_XOFFSET;
        this.graphY = SCREEN_HEIGHT - SCREEN_YOFFSET;
    }

    // Graphs a function on the front end
    public void graph(MathFunction f){
        invalidate();
    }
    // Paints a function on the front end
    public void paint(Graphics g)
    {
        // Drawing Y-axis
        g.drawLine(SCREEN_XOFFSET,SCREEN_YOFFSET,SCREEN_XOFFSET, SCREEN_HEIGHT - SCREEN_YOFFSET);

        // Drawing X-axis
        g.drawLine(SCREEN_XOFFSET,SCREEN_HEIGHT - SCREEN_YOFFSET,SCREEN_WIDTH - SCREEN_XOFFSET, SCREEN_HEIGHT - SCREEN_YOFFSET);

        if(f != null && f.getStringF().equals("x"))
        {
            System.out.println("Drawing x line");
            g.drawLine(SCREEN_XOFFSET, SCREEN_HEIGHT - SCREEN_YOFFSET, SCREEN_WIDTH, 0);
        }
        if(f != null && f.getStringF().equals("x^2"))
        {
            System.out.println("Drawing x^2 line");
            x = 0;
            y = x * x;
            for(int i = 0; i < Integer.MAX_VALUE; i++)
            {
                x1 = x + dx;
                y1 = x1 * x1;
                g.drawLine((int)(graphX + x),(int)(graphY - y),(int)(graphX + x1), (int)(graphX - y1));
                x = x1;
                y = y1;
            }
        }
    }

    public MathFunction getF() {
        return f;
    }

    public void setF(MathFunction f) {
        this.f = f;
    }
}
