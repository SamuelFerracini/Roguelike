package Entidades;

import Map.Mundo;
import Class.Ponto2D;
import Class.Personagem;

public class Tesouro extends Personagem {
    
    public static final char SIMBOLO = 'T';
    
    public Tesouro(Ponto2D posicao) {
        super(posicao, SIMBOLO);
    }

}
