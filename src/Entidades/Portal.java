package Entidades;

import Class.Entidade;
import Class.Ponto2D;
import Map.Mundo;

public class Portal extends Entidade{
    
    public static final char SIMBOLO = '@';
    
    public Portal(Ponto2D posicao) {
        super(posicao, SIMBOLO);
    }
    
    
}
