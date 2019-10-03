package Tools;

import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class keyEvent implements KeyListener {

    @Override
    public void keyTyped(KeyEvent ke) {

    }
    
    @Override
    public void keyReleased(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("w");
        }
    }

    

    public static void main(String arg[]) {
        JFrame jf = new JFrame("key event");
        jf.setSize(400, 400);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.addKeyListener(new keyEvent());
        jf.setVisible(true);

    }

}
