import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;

public class GraphListener implements KeyListener {
    public static final int BALL_START_RADIUS = 25,
            BALL_START_X = 100,
            BALL_START_Y = 100,
            STEP_SIZE = 10;
    // Instance variables
    private FrontEnd window;
    private Function f;

    // Constructors
    public GraphListener() {
        window = new FrontEnd();

        // The addKeyListener method attaches to this KeyListener object
        // an object that implements the KeyListener interface (i.e. supplies the keyTyped, keyReleased, and keyPressed methods)
        // By passsing the parameter "this"
        // we are saying that this specific KeyListenerDemo object
        // supplies its own KeyListener functionality (contains the 3 required KeyListener methods).
        window.addKeyListener(this);               // #4 Required for KeyListener
    }

    public static void main(String[] args) {
        GraphListener glDemo = new GraphListener();
    }

    //////////////////////////////////////////////////////////////
    /*
     * Methods all KeyListeners must supply
     */
    //////////////////////////////////////////////////////////////
    @Override
    public void keyTyped(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // The keyCode lets you know which key was pressed
        f = new Function(1,1,1,1,1,1,"function");
        window.setF(f);
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                System.out.println("Print left key pressed");
                f.setStringF("x");
                window.graph(f);
                break;
            case KeyEvent.VK_RIGHT:
                f.setStringF("x^2");
                window.graph(f);
                break;
            /*
                case KeyEvent.VK_UP:
                int topOfPane = window.getInsets().top;
                b.shiftY(-STEP_SIZE, topOfPane, FrontEnd.SCREEN_HEIGHT);
                break;
            case KeyEvent.VK_DOWN:
                b.shiftY(STEP_SIZE, 0, FrontEnd.SCREEN_HEIGHT);
                break;
            case KeyEvent.VK_Z:
                b.setCenter((int)(Math.random() * FrontEnd.SCREEN_WIDTH), (int)(Math.random() * FrontEnd.SCREEN_HEIGHT));
                break;
            case KeyEvent.VK_S:
                b.setRadius(b.getRadius() / 2);
                break;
            case KeyEvent.VK_B:
                b.setRadius(b.getRadius() * 2);
                break;
            case KeyEvent.VK_C:
                b.setColor(Color.BLACK);
                break;

             */
        }
        window.repaint();
    }

}
