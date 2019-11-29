package Entidades;

import Characters.Jogador;
import Map.Mundo;
import Class.Ponto2D;
import Class.Personagem;

public class Tesouro extends Personagem {

    public static final char SIMBOLO = 'T';

    public Tesouro(Ponto2D posicao) {
        super(posicao, SIMBOLO);
    }

    @Override
    public Personagem atualizar(Mundo mundo) {
        if (this.posicao.getX() == mundo.getJogador().posicao.getX()
                && this.posicao.getY() == mundo.getJogador().posicao.getY()) {
            mundo.getJogador().incrementaOuroAleatorio();
            return this;
        }
        return null;
    }

}
