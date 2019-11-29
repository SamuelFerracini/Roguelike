package Entidades;

import Class.Entidade;
import Class.Ponto2D;
import Class.Personagem;
import Map.Mundo;

public class Runa extends Personagem{
    
    public static final char SIMBOLO = 'R';
    private boolean visivel;
    
    public Runa(Ponto2D posicao) {
        super(posicao, SIMBOLO);
        this.visivel = true;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    @Override
    public Personagem atualizar(Mundo mundo) {
       if (this.posicao.getX() == mundo.getJogador().posicao.getX()
                && this.posicao.getY() == mundo.getJogador().posicao.getY()) {
            mundo.getJogador().setTemRuna(true);
            return this;
        }
        return null;
    }
    
    
   
    
}
