import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class FrontEnd extends JFrame {
    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 800;
    public static int SCREEN_XOFFSET = 100;
    public static int SCREEN_YOFFSET = 100;
    private Function f;


    public FrontEnd() {
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Graph ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //Graphs a function on the front end
    public void graph(Function f){

    }

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

    }

    public Function getF() {
        return f;
    }

    public void setF(Function f) {
        this.f = f;
    }
}
