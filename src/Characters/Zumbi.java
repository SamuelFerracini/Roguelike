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
    private static final int RANGE = 3;
    private static int teste;

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
        int diferenca = 10000;
        Entidade alvo = new Entidade();
        //PROCURA O ALVO MAIS PROXIMO DO ZUMBI
        for (Entidade entidade : mundo.getEntidades()) {
            if (entidade.getSimbolo() != Zumbi.SIMBOLO && entidade.getSimbolo() != Tesouro.SIMBOLO && entidade.getSimbolo() != Chave.SIMBOLO && entidade.getSimbolo() != Portal.SIMBOLO) {
                if (diferenca > (Math.abs(this.posicao.getX() - entidade.posicao.getX()) + Math.abs(this.posicao.getY() - entidade.posicao.getY()))) {
                    alvo = entidade;
                    diferenca = (Math.abs(this.posicao.getX() - entidade.posicao.getX()) + Math.abs(this.posicao.getY() - entidade.posicao.getY()));
                }
            }
        }
        //PROCURA O ALVO MAIS PROXIMO DO ZUMBI DANDO PREFERENCIA PARA O PLAYER
        if (diferenca > Math.abs(mundo.getJogador().posicao.getX() - this.posicao.getX()) + Math.abs(mundo.getJogador().posicao.getY() - this.posicao.getY())) {
            alvo = mundo.getJogador();
            diferenca = Math.abs(mundo.getJogador().posicao.getX() - this.posicao.getX()) + Math.abs(mundo.getJogador().posicao.getY() - this.posicao.getY());
        }
        //VERIFICA SE O ALVO ESTA NA RANGE DE 5 DO ZUMBI
        if ((alvo.posicao.getX() >= (this.posicao.getX() - RANGE) && alvo.posicao.getX() <= (this.posicao.getX() + RANGE)) && (alvo.posicao.getY() >= (this.posicao.getY() - RANGE) && alvo.posicao.getY() <= (this.posicao.getY() + RANGE))) {
            int xHorizontal;
            int yHorizontal;
            int xVertical;
            int yVertical;

            if (this.posicao.getX() > alvo.posicao.getX()) {
                // ESQUERDA
                xHorizontal = -1;
                yHorizontal = 0;
            } else if (this.posicao.getX() < alvo.posicao.getX()) {
                // DIREITA
                xHorizontal = 1;
                yHorizontal = 0;
            } else {
                xHorizontal = 0;
                yHorizontal = 0;
            }
            if (this.posicao.getY() < alvo.posicao.getY()) {
                // CIMA
                xVertical = 0;
                yVertical = 1;
            } else if (this.posicao.getY() > alvo.posicao.getY()) {
                // BAIXO
                xVertical = 0;
                yVertical = -1;
            } else {
                xVertical = 0;
                yVertical = 0;
            }

            if (this.posicao.getX() == alvo.posicao.getX()) {
                if (!mundo.bloqueado(this.posicao.getX() + xVertical, this.posicao.getY() + yVertical)) {
                    mover(mundo, xVertical, yVertical);
                } else {
                    if (!mundo.bloqueado(this.posicao.getX() + xHorizontal, this.posicao.getY() + yHorizontal)) {
                        mover(mundo, xHorizontal, yHorizontal);
                    }
                }
            //SE NAO TIVER VAGABUNDO NA RANGE ELE ANDA ALEATÓRIO
            } else {
                if (!mundo.bloqueado(this.posicao.getX() + xHorizontal, this.posicao.getY() + yHorizontal)) {
                    mover(mundo, xHorizontal, yHorizontal);
                } else {
                    if (!mundo.bloqueado(this.posicao.getX() + xVertical, this.posicao.getY() + yVertical)) {
                        mover(mundo, xVertical, yVertical);
                    }

                }

            }

        } else {

            int direcao = (int) (Math.random() * 1000 % QUANTIDADE_MOVIMENTOS);

            // desloca a criatura conforme o valor aleatório gerado
            if (direcao == FICAR_PARADO) {
                mover(mundo, 0, 0);
            } else if (direcao == MOVER_BAIXO) {
                mover(mundo, 0, 1);
            } else if (direcao == MOVER_CIMA) {
                mover(mundo, 0, -1);
            } else if (direcao == MOVER_DIREITA) {
                mover(mundo, 1, 0);
            } else if (direcao == MOVER_ESQUERDA) {
                mover(mundo, -1, 0);
            }
        }

    }

}
