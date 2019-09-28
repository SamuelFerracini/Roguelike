package Game;

import Tools.MundoBuilder;
import Characters.Jogador;
import Map.Mundo;
import Class.Ponto2D;

public class Jogo {

    private Mundo mundo;
    private Jogador jogador;
    private int largura, altura;

    public Jogo(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    void criarMundo() {

        int x = largura / 2;
        int y = altura / 2;
        int passo = 2000;

        jogador = new Jogador(3, new Ponto2D(x, y), 'J');
        mundo = new MundoBuilder(largura, altura)
                .preencher('#', true)
                .criarCaminho(x, y, passo)
                .criarCriaturas(10, 3, 5)
                .criaEntidades(3)
                .build();

        mundo.setJogador(jogador);

    }

    public void executar() {
        criarMundo();
        while (jogador.vivo()) {
            mundo.desenhar();
            mundo.atualizar();
        }
    }
}
