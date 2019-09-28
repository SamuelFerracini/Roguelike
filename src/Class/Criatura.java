package Class;

import Map.Mundo;
import Class.Ponto2D;
import Class.Personagem;

public class Criatura extends Personagem {

    private static final int FICAR_PARADO = 0;
    private static final int MOVER_BAIXO = 1;
    private static final int MOVER_CIMA = 2;
    private static final int MOVER_DIREITA = 3;
    private static final int MOVER_ESQUERDA = 4;
    private static final int QUANTIDADE_MOVIMENTOS = 5;

    public Criatura(Ponto2D posicao, char simbolo) {
        super(posicao, simbolo);
    }

}
