package Characters;

import Class.Entidade;
import Class.Personagem;
import Class.Ponto2D;
import Entidades.Runa;
import Entidades.Portal;
import Entidades.Tesouro;
import Map.Mundo;

public class Lobo extends Personagem {

    public static final char SIMBOLO = 'L';
    private static final int RANGE = 7;
    private static final int QUANTIDADE_MOVIMENTOS = 10;

    public Lobo(Ponto2D posicao) {
        super(posicao, SIMBOLO);
    }
    
    private void move(Mundo mundo){
    int diferenca = 10000;
        Entidade alvo = new Entidade();

        boolean naoTemOvelha = true;
        for (Personagem personagem : mundo.getPersonagens()) {
            if (personagem.getSimbolo() == Ovelha.SIMBOLO) {
                naoTemOvelha = false;
                if (diferenca > (Math.abs(this.posicao.getX() - personagem.posicao.getX()) + Math.abs(this.posicao.getY() - personagem.posicao.getY()))) {
                    alvo = personagem;
                    diferenca = (Math.abs(this.posicao.getX() - personagem.posicao.getX()) + Math.abs(this.posicao.getY() - personagem.posicao.getY()));
                }
            } 
        }

        if (naoTemOvelha) {
            moveAleatorio(mundo, QUANTIDADE_MOVIMENTOS);
            return;
        }

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
            moveAleatorio(mundo, QUANTIDADE_MOVIMENTOS);
        }
    }

    @Override
    public Personagem atualizar(Mundo mundo) {
        move(mundo);
        for (Personagem personagem : mundo.getPersonagens()) {

            if ((personagem.getSimbolo() == Ovelha.SIMBOLO )) {
                if ((this.posicao.getX() == personagem.posicao.getX() && this.posicao.getY() == personagem.posicao.getY())) {
                    return personagem;
                }
            }

        }
         return null;
        
        
    }

}
