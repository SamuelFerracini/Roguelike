package Characters;

import Class.Entidade;
import Map.Mundo;
import Class.Ponto2D;
import Class.Personagem;
import Entidades.Runa;
import Entidades.Portal;
import Entidades.Tesouro;

public class Zumbi extends Personagem {

    public static final char SIMBOLO = 'Z';
    private static final int QUANTIDADE_MOVIMENTOS = 5;
    private static final int RANGE = 3;

    public Zumbi(Ponto2D posicao) {
        super(posicao, SIMBOLO);
    }

    private void move(Mundo mundo) {
        int diferenca = 10000;
        Entidade alvo = new Entidade();
        //PROCURA O ALVO MAIS PROXIMO DO ZUMBI
        for (Entidade entidade : mundo.getPersonagens()) {
            if (entidade.getSimbolo() != this.SIMBOLO && entidade.getSimbolo() != Tesouro.SIMBOLO && entidade.getSimbolo() != Runa.SIMBOLO && entidade.getSimbolo() != Portal.SIMBOLO) {
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
        if (verificaRange(alvo, RANGE)) {
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
                //SE ESTIVER BLOQUEADO ELE ANDA ALEATÓRIO
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
            moveAleatorio(mundo, QUANTIDADE_MOVIMENTOS);
        }
    }

    @Override
    public Personagem atualizar(Mundo mundo) {
        move(mundo);

        if ((this.posicao.getX() == mundo.getJogador().posicao.getX() && this.posicao.getY() == mundo.getJogador().posicao.getY())) {
            mundo.getJogador().tomarDano(1);
            return this;
        }

        for (Personagem personagem : mundo.getPersonagens()) {

            if ((personagem.getSimbolo() == Ovelha.SIMBOLO || personagem.getSimbolo() == Lobo.SIMBOLO)) {
                if ((this.posicao.getX() == personagem.posicao.getX() && this.posicao.getY() == personagem.posicao.getY())) {
                    return personagem;
                }
            }

        }
        return null;
    }

}
