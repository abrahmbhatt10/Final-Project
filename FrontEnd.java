import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class FrontEnd extends JFrame {
    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 800;
    public static int SCREEN_XOFFSET = 100;
    public static int SCREEN_YOFFSET = 100;
    private Function f;
    int dx;
    int x;
    int y;


    public FrontEnd() {
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Graph ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.dx = SCREEN_WIDTH / Integer.MAX_VALUE;
    }

    // Graphs a function on the front end
    public void graph(Function f){

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
            int x;
            for(int i = 0; i < Integer.MAX_VALUE; i++)
            {
                x = (int) (i * dx);
                y = SCREEN_HEIGHT - (int)(x^2);
                g.drawLine(SCREEN_XOFFSET + x,y,x + dx, y + dx);
            }
        }
        if(f != null && f.getStringF().equals("sinx"))
        {
            System.out.println("Drawing sinx line");
            for(int i = 0; i < Integer.MAX_VALUE; i++)
            {
                x = (int) (i * dx);
                y = SCREEN_HEIGHT - (int)Math.sin(x);
                g.drawLine(x,y,x + dx, y + dx);
            }
        }
        if(f != null && f.getStringF().equals("cosx"))
        {
            System.out.println("Drawing cosx line");
            for(int i = 0; i < Integer.MAX_VALUE; i++)
            {
                x = (int) (i * dx);
                y = SCREEN_HEIGHT - (int)Math.cos(x);
                g.drawLine(x,y,x + dx, y + dx);
            }
        }
        if(f != null && f.getStringF().equals("tanx"))
        {
            System.out.println("Drawing tanx line");
            for(int i = 0; i < Integer.MAX_VALUE; i++)
            {
                x = (int) (i * dx);
                y = SCREEN_HEIGHT - (int)Math.tan(x);
                g.drawLine(x,y,x + dx, y + dx);
            }
        }
    }

    public Function getF() {
        return f;
    }

    public void setF(Function f) {
        this.f = f;
    }
}
