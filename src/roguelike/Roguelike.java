package roguelike;

import Characters.Jogador;
import Class.Loja;
import Game.Jogo;
import Tools.keyEvent;
import java.util.Scanner;
import javax.swing.JFrame;

public class Roguelike {

    public static void main(String[] args) {
        Tools.Tools.mostraLogoJogo();
        System.out.println("1 . Começar um novo jogo");
        System.out.println("2 . Carregar jogo salvo");
        System.out.println("3 . Highscores");
        System.out.println("4 . Sair");
        System.out.println("5 . Créditos");
        System.out.print("Resposta: ");
        Scanner keyboard = new Scanner(System.in);
        int resposta = keyboard.nextInt();
        switch(resposta){
            case 1:
                new Jogo().executar();
                break;
            case 2:
                Jogador jogadorImportado = Tools.Tools.importaDados();
                new Jogo().executar(jogadorImportado);
                break;
            case 3:
                //Highscores
                break;
            case 4:
                break;
            case 5:
                //TEM QUE COLOCAR OS CREDITOS NESSA FUNC
                Tools.Tools.mostrarCreditos();
                break;
                
        }
        
//         JFrame jf = new JFrame("key event");
//        jf.setSize(400, 400);
//        
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        jf.addKeyListener(new keyEvent());
//        jf.setVisible(true);
    }

}
