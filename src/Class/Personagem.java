package Class;

import Map.Mundo;

public class Personagem extends Entidade {

    private static final int FICAR_PARADO = 0;
    private static final int MOVER_BAIXO = 1;
    private static final int MOVER_CIMA = 2;
    private static final int MOVER_DIREITA = 3;
    private static final int MOVER_ESQUERDA = 4;

    public Personagem(Ponto2D posicao, char simbolo) {
        super(posicao, simbolo);
    }

    public Personagem() {

    }

    protected void moveAleatorio(Mundo mundo, int quantidadeMovimentos) {

        int direcao = (int) (Math.random() * 1000 % quantidadeMovimentos);

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

    public void mover(Mundo mundo, int deltaX, int deltaY) {
        if (!mundo.bloqueado(posicao.getX() + deltaX, posicao.getY() + deltaY)) {
            posicao.setX(posicao.getX() + deltaX);
            posicao.setY(posicao.getY() + deltaY);
        }
    }

    public Personagem atualizar(Mundo mundo) {
        return null;
    }

}
