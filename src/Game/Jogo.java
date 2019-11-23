package Game;

import Characters.Jogador;
import Class.Loja;
import Map.Mundo;
import Class.Ponto2D;
import Tools.MundoBuilder;
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
    private int passo = 2000;
    private int x = largura / 2;
    private int y = altura / 2;

    public Jogo() {
    }

    private void criarMundo() {
        jogador = new Jogador(new Ponto2D(x, y));
        populaMapa(x, y, passo);
        mundo.setJogador(jogador);
    }
    
    private void criarMundo(Jogador jogador) {
        jogador.setPosicao(new Ponto2D(x, y));
        populaMapa(x, y, passo);
        mundo.setJogador(jogador);
    }

    private void sobeAndar(Jogador jogadorBuffado) {
        aumentaDificuldade();
        jogador = new Jogador(jogadorBuffado);
        populaMapa(x, y, passo);
        mundo.setJogador(jogador);
    }

    private void aumentaDificuldade() {
        qtdTesouro = new Random().nextInt(3);
        if (jogador.getNivelAndar() % 5 == 0) {
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
        Tools.Tools.clearScreen();
        criarMundo();
        while (jogador.vivo()) {
            mundo.desenhar();
            if (mundo.atualizar() == 2) {
                jogador.setTemRuna(false);
                Loja loja = new Loja(jogador);
                loja.mostraLoja();
                Jogador jogadorBufado = loja.mostraProdutos();
                sobeAndar(jogadorBufado);
            }
        }
        Tools.Tools.mostrarMorte();

    }
    
    public void executar(Jogador jogador) {
        Tools.Tools.clearScreen();
        criarMundo(jogador);
        while (jogador.vivo()) {
            mundo.desenhar();
            if (mundo.atualizar() == 2) {
                jogador.setTemRuna(false);
                Loja loja = new Loja(jogador);
                loja.mostraLoja();
                Jogador jogadorBufado = loja.mostraProdutos();
                sobeAndar(jogadorBufado);
            }
        }
        Tools.Tools.mostrarMorte();

    }

    private void populaMapa(int x, int y, int passo) {
        mundo = new MundoBuilder(largura, altura)
                .preencher('#', true)
                .criarCaminho(x, y, passo)
                .criarCriaturas(qtdZumbi, qtdOvelha, qtdLobo)
                .criaEntidades(qtdTesouro)
                .build();
    }

}
