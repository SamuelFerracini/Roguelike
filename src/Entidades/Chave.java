package Entidades;

import Class.Entidade;
import Class.Ponto2D;
import Map.Mundo;

public class Chave extends Entidade{
    
    public static final char SIMBOLO = 'C';
    private boolean visivel;
    
    public Chave(Ponto2D posicao) {
        super(posicao, SIMBOLO);
        this.visivel = true;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
   
    
}
