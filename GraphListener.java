import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GraphListener implements KeyListener {
    // Instance Variables
    public static final int BALL_START_RADIUS = 25,
            BALL_START_X = 100,
            BALL_START_Y = 100,
            STEP_SIZE = 10;
    // Instance variables
    private FrontEnd window;
    private MathFunction f;

    // Constructors
    public GraphListener(FrontEnd window) {
        this.window = window;

        // The addKeyListener method attaches to this KeyListener object
        // an object that implements the KeyListener interface (i.e. supplies the keyTyped, keyReleased, and keyPressed methods)
        // By passsing the parameter "this"
        // we are saying that this specific KeyListenerDemo object
        // supplies its own KeyListener functionality (contains the 3 required KeyListener methods).
        window.addKeyListener(this);               // #4 Required for KeyListener
    }

    public static void main(String[] args) {
        GraphSelection glDemo = new GraphSelection();
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
        f = new MathFunction("function", window);
        window.setF(f);
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_LEFT:
                    System.out.println("Print left key pressed");
                    f.setStringF("x");
                    break;
                case KeyEvent.VK_RIGHT:
                    f.setStringF("x^2");
                    break;
                case KeyEvent.VK_UP:
                    f.setStringF("sinx");
                    break;
                case KeyEvent.VK_DOWN:
                    f.setStringF("cosx");
                    break;
            }
            window.repaint();
    }
}
