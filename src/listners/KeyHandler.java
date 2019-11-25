package listners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Tab is pressed");
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Tab is pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Tab is pressed");
        }
    }
}
