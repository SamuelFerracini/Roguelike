package roguelike;

import Game.Jogo;
import Tools.keyEvent;
import java.util.Scanner;
import javax.swing.JFrame;


public class Roguelike {

    public static void main(String[] args) {
//         JFrame jf = new JFrame("key event");
//        jf.setSize(400, 400);
//        
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        jf.addKeyListener(new keyEvent());
//        jf.setVisible(true);
        new Jogo().executar();
    }
    
}
