package Game;

import Tools.MundoBuilder;
import Characters.Jogador;
import Map.Mundo;
import Class.Ponto2D;
import java.util.Random;

public class Jogo {

    private Mundo mundo;
    private Jogador jogador;
    private int largura = 100, altura = 30;
    private int qtdZumbi = 1;
    private int qtdOvelha = 1;
    private int qtdLobo = 1;
    private int qtdChave = 1;
    private int qtdTesouro = 1;

    public Jogo() {    }

    void criarMundo() {

        int x = largura / 2;
        int y = altura / 2;
        int passo = 2000;

        jogador = new Jogador(3, new Ponto2D(x, y));
        mundo = new MundoBuilder(largura, altura)
                .preencher('#', true)
                .criarCaminho(x, y, passo)
                .criarCriaturas(qtdZumbi, qtdOvelha, qtdLobo)
                .criaEntidades(qtdTesouro)
                .build();

        mundo.setJogador(jogador);
    }

    public void sobeAndar() {

        int x = largura / 2;
        int y = altura / 2;
        int passo = 2000;
        
        aumentaDificuldade();
        qtdTesouro = new Random().nextInt(3);

        jogador = new Jogador(jogador.getVidas(), new Ponto2D(x, y), jogador.getOuro(), jogador.getAndar(), jogador.getEscudo());
        mundo = new MundoBuilder(largura, altura)
                .preencher('#', true)
                .criarCaminho(x, y, passo)
                .criarCriaturas(qtdZumbi, qtdOvelha, qtdLobo)
                .criaEntidades(qtdTesouro)
                .build();

        mundo.setJogador(jogador);
    }

    void aumentaDificuldade() {
        if (jogador.getAndar() % 5 == 0) {
            this.qtdZumbi += (jogador.getAndar() / 5);
            this.qtdLobo += 1;
            this.qtdOvelha += this.qtdZumbi + (jogador.getAndar() % 5);
        } else {
            this.qtdZumbi += 1;
            this.qtdLobo += 1;
            this.qtdOvelha += 1;
        }
    }

    public void executar() {
        criarMundo();
        while (jogador.vivo()) {
            mundo.desenhar();
            if(mundo.atualizar() == 2){
                sobeAndar();
            }
            clearScreen();
        }
        System.out.println("Você morreu!");
    }
    
    public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
   }
}


