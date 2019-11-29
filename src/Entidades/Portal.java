package Entidades;

import Class.Entidade;
import Class.Ponto2D;
import Map.Mundo;
import Class.Personagem;

public class Portal extends Personagem{
    
    public static final char SIMBOLO = '@';
    
    public Portal(Ponto2D posicao) {
        super(posicao, SIMBOLO);
    }

    @Override
    public Personagem atualizar(Mundo mundo) {
        if ((this.posicao.getX() == mundo.getJogador().posicao.getX()
                && this.posicao.getY() == mundo.getJogador().posicao.getY()) && mundo.getJogador().isTemRuna()) {
            mundo.setEstado(2);
            return this;
        }
        return null;
    }
    
    
    
    
}
