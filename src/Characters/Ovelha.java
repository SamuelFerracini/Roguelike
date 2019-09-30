package Characters;

import Class.Entidade;
import Class.Personagem;
import Class.Ponto2D;
import Entidades.Chave;
import Entidades.Portal;
import Entidades.Tesouro;
import Map.Mundo;

public class Ovelha extends Personagem{
    
    public static final char SIMBOLO = 'O';
    private static final int FICAR_PARADO = 0;
    private static final int MOVER_BAIXO = 1;
    private static final int MOVER_CIMA = 2;
    private static final int MOVER_DIREITA = 3;
    private static final int MOVER_ESQUERDA = 4;
    private static final int QUANTIDADE_MOVIMENTOS = 5;
    
    public Ovelha(Ponto2D posicao) {
        super(posicao, SIMBOLO);
    }
    
    
//    @Override
//    public void atualizar(Mundo mundo) {

//        int somaOvelha = this.posicao.getX() + this.posicao.getY();
//        int diferenca = 1000000;
//        Entidade alvo = new Entidade();
//
//        for (Entidade entidade : mundo.getEntidades()) {
//            if (entidade.getSimbolo() != Ovelha.SIMBOLO && entidade.getSimbolo() != Tesouro.SIMBOLO && entidade.getSimbolo() != Chave.SIMBOLO && entidade.getSimbolo() != Portal.SIMBOLO) {
//                if (diferenca > Math.abs(entidade.posicao.getX() + entidade.posicao.getY() - somaOvelha)) {
//                    alvo = entidade;
//                    diferenca = Math.abs(entidade.posicao.getX() + entidade.posicao.getY() - somaOvelha);
//                }
//            }
//        }
//        
//        if (Math.abs(alvo.posicao.getX() - this.posicao.getX()) != 0) {
//            if (alvo.posicao.getX() < this.posicao.getX()) {
//                mover(mundo, 1, 0);
//            } else {
//                mover(mundo, -1, 0);
//            }
//        } else {
//            if (alvo.posicao.getY() < this.posicao.getY()) {
//                mover(mundo, 0, 1);
//            } else {
//                mover(mundo, 0, -1);
//            }
//        }
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
