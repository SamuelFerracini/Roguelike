package Characters;

import Map.Mundo;
import Class.Ponto2D;
import Class.Personagem;

public class Zumbi extends Personagem {
    
    public static final char SIMBOLO = 'Z';
    private static final int FICAR_PARADO = 0;
    private static final int MOVER_BAIXO = 1;
    private static final int MOVER_CIMA = 2;
    private static final int MOVER_DIREITA = 3;
    private static final int MOVER_ESQUERDA = 4;
    private static final int QUANTIDADE_MOVIMENTOS = 5;

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

        // criar um número aleatório entre 0 e 100,
        // logo em seguida, calcula o resto da divisão por 5, 
        // ou seja, só podemos ter os seguintes valores: 0, 1, 2, 3 e 4
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
