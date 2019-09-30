package Characters;

import Class.Entidade;
import Map.Mundo;
import Class.Ponto2D;
import Class.Personagem;
import Entidades.Chave;
import Entidades.Portal;
import Entidades.Tesouro;

public class Zumbi extends Personagem {

    public static final char SIMBOLO = 'Z';
    private static final int FICAR_PARADO = 0;
    private static final int MOVER_BAIXO = 1;
    private static final int MOVER_CIMA = 2;
    private static final int MOVER_DIREITA = 3;
    private static final int MOVER_ESQUERDA = 4;
    private static final int QUANTIDADE_MOVIMENTOS = 5;

    public Zumbi(Ponto2D posicao) {
        super(posicao, SIMBOLO);
    }

//    @Override
//    public void atualizar(Mundo mundo) {
//        int direcao = (int)(Math.random() * 1000) % 5;
//        if (direcao == 1)
//            mover(mundo, -1, 0);
//        if (direcao == 2)
//            mover(mundo, 0, -1);
//        if (direcao == 3)
//            mover(mundo, 0, 1);
//        if (direcao == 4)
//            mover(mundo, 1, 0);
//    }
    @Override
    public void atualizar(Mundo mundo) {

        int somaZumbi = this.posicao.getX() + this.posicao.getY();
        int diferenca = 1000000;
        Entidade alvo = new Entidade();

        for (Entidade entidade : mundo.getEntidades()) {
            if (entidade.getSimbolo() != Zumbi.SIMBOLO && entidade.getSimbolo() != Tesouro.SIMBOLO && entidade.getSimbolo() != Chave.SIMBOLO && entidade.getSimbolo() != Portal.SIMBOLO) {
                if (diferenca > Math.abs(entidade.posicao.getX() + entidade.posicao.getY() - somaZumbi)) {
                    alvo = entidade;
                    diferenca = Math.abs(entidade.posicao.getX() + entidade.posicao.getY() - somaZumbi);
                }
            }
        }

        if (diferenca > Math.abs(mundo.getJogador().posicao.getX() + mundo.getJogador().posicao.getY() - somaZumbi)) {
            alvo = mundo.getJogador();
            diferenca = Math.abs(mundo.getJogador().posicao.getX() + mundo.getJogador().posicao.getY() - somaZumbi);
        }

        if (Math.abs(alvo.posicao.getX() - this.posicao.getX()) != 0) {
            if (alvo.posicao.getX() < this.posicao.getX()) {
                if (!mundo.bloqueado(this.posicao.getX() - 1, this.posicao.getY())) {
                    mover(mundo, -1, 0);
                    return;
                }
            } else {
                if (!mundo.bloqueado(this.posicao.getX() + 1, this.posicao.getY())) {
                    mover(mundo, +1, 0);
                    return;
                }
            }
        }
        if (Math.abs(alvo.posicao.getY() - this.posicao.getY()) != 0) {
            if (alvo.posicao.getY() < this.posicao.getY()) {
                if (!mundo.bloqueado(this.posicao.getX(), this.posicao.getY() - 1)) {
                    mover(mundo, 0, -1);
                    return;
                }
            } else {
                if (!mundo.bloqueado(this.posicao.getX(), this.posicao.getY() + 1)) {
                    mover(mundo, 0, +1);
                    return;
                }
            }
        }
    }

}
