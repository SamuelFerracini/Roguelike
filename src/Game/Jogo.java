package Game;

import Tools.MundoBuilder;
import Characters.Jogador;
import Class.Loja;
import Class.Morte;
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

        jogador = new Jogador(new Ponto2D(x, y));
        mundo = new MundoBuilder(largura, altura)
                .preencher('#', true)
                .criarCaminho(x, y, passo)
                .criarCriaturas(qtdZumbi, qtdOvelha, qtdLobo)
                .criaEntidades(qtdTesouro)
                .build();

        mundo.setJogador(jogador);
    }

    public void sobeAndar(Jogador jogadorBuffado) {
        
        int x = largura / 2;
        int y = altura / 2;
        int passo = 2000;
        
        aumentaDificuldade();
        qtdTesouro = new Random().nextInt(3);

        jogador = new Jogador(jogadorBuffado.getQtdVidas(), jogadorBuffado.getNivelVitalidade(), jogadorBuffado.isTemRuna(), jogadorBuffado.getQtdOuro(), jogadorBuffado.getNivelAndar(), jogadorBuffado.getNivelEscudo(), new Ponto2D(x, y));
        mundo = new MundoBuilder(largura, altura)
                .preencher('#', true)
                .criarCaminho(x, y, passo)
                .criarCriaturas(qtdZumbi, qtdOvelha, qtdLobo)
                .criaEntidades(qtdTesouro)
                .build();

        mundo.setJogador(jogador);
    }

    void aumentaDificuldade() {
        if (jogador.getNivelAndar()% 5 == 0) {
            this.qtdZumbi += (jogador.getNivelAndar() / 5);
            this.qtdLobo += 1;
            this.qtdOvelha += this.qtdZumbi + (jogador.getNivelAndar() % 5);
        } else {
            this.qtdZumbi += 1;
            this.qtdLobo += 1;
            this.qtdOvelha += 1;
        }
    }

    public void executar() {
        clearScreen();
        criarMundo();
        while (jogador.vivo()) {
            mundo.desenhar();
            if(mundo.atualizar() == 2){
                Loja loja = new Loja(jogador);
                loja.mostraLoja();
                Jogador jogadorBufado = loja.mostraProdutos();
                sobeAndar(jogadorBufado);
            }
            clearScreen();
        }
        Morte.mostrarMorte();
    }
    
    private static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
   }
}


