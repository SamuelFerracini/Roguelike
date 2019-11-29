package Tools;

import Characters.Zumbi;
import Map.Mundo;
import Class.Ponto2D;
import Class.Personagem;
import Map.Celula;
import java.util.ArrayList;
import java.util.List;
import Characters.Ovelha;
import Characters.Lobo;
import Entidades.Portal;
import Class.Entidade;
import Entidades.Runa;
import Entidades.Tesouro;

public class MundoBuilder {

    public final int largura, altura;
    public Celula[][] mapa;
    public List<Personagem> personagens = new ArrayList<>();

    public MundoBuilder(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;

    }

    public MundoBuilder preencher(char simbolo, boolean bloqueado) {
        mapa = new Celula[largura][altura];
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                Ponto2D posicao = new Ponto2D(x, y);
                mapa[x][y] = new Celula(bloqueado, posicao, simbolo);
            }
        }
        return this;
    }

    public MundoBuilder criarCaminho(int x, int y, int passos) {
        mapa[x][y].setSimbolo(' ');
        mapa[x][y].setBloqueado(false);

        for (int i = 0; i < passos; i++) {
            int direcao = (int) (Math.random() * 1000) % 4;
            if (direcao == 0 && (x + 1) < largura - 1) {
                x++;
            } else if (direcao == 1 && (x - 1) > 0) {
                x--;
            } else if (direcao == 2 && (y + 1) < altura - 1) {
                y++;
            } else if (direcao == 3 && (y - 1) > 0) {
                y--;
            }

            mapa[x][y].setSimbolo(' ');
            mapa[x][y].setBloqueado(false);
        }
        return this;
    }

    // Método que adiciona criaturas no mapa
    // @quantidadeCriaturas : número de criaturas que queremos colocar no mapa
    public MundoBuilder criarCriaturas(int qtdZumbie, int qtdOvelha, int qtdLobo) {
        int x, y;
        // Cria N criaturas
        for (int i = 0; i < qtdZumbie; i++) {

            // Impede que uma criatura seja criada em cima de uma parede
            do {
                x = (int) (Math.random() * 1000 % largura);
                y = (int) (Math.random() * 1000 % altura);
            } while (mapa[x][y].isBloqueado());

            // Adiciona a criatura na lista de criaturas
            Personagem zumbi = new Zumbi(new Ponto2D(x, y)); 
            personagens.add(zumbi);
        }
        for (int i = 0; i < qtdOvelha; i++) {

            // Impede que uma criatura seja criada em cima de uma parede
            do {
                x = (int) (Math.random() * 1000 % largura);
                y = (int) (Math.random() * 1000 % altura);
            } while (mapa[x][y].isBloqueado());

            // Adiciona a criatura na lista de criaturas
            Personagem ovelha = new Ovelha(new Ponto2D(x, y)); 
            personagens.add(ovelha);
        }
        
        for (int i = 0; i < qtdLobo; i++) {

            // Impede que uma criatura seja criada em cima de uma parede
            do {
                x = (int) (Math.random() * 1000 % largura);
                y = (int) (Math.random() * 1000 % altura);
            } while (mapa[x][y].isBloqueado());

            // Adiciona a criatura na lista de criaturas
            Personagem lobo = new Lobo(new Ponto2D(x, y)); 
            personagens.add(lobo);
        }
        return this;
    }

    public MundoBuilder criaEntidades(int qtdTesouro){
        int x, y;
            do {
                x = (int) (Math.random() * 1000 % largura);
                y = (int) (Math.random() * 1000 % altura);
            } while (mapa[x][y].isBloqueado());

            Personagem portal = new Portal(new Ponto2D(x, y)); 
            personagens.add(portal);
            
            do {
                x = (int) (Math.random() * 1000 % largura);
                y = (int) (Math.random() * 1000 % altura);
            } while (mapa[x][y].isBloqueado());
            
            Personagem chave = new Runa(new Ponto2D(x, y)); 
            personagens.add(chave);
            
            for (int i = 0; i < qtdTesouro; i++) {

            // Impede que uma criatura seja criada em cima de uma parede
            do {
                x = (int) (Math.random() * 1000 % largura);
                y = (int) (Math.random() * 1000 % altura);
            } while (mapa[x][y].isBloqueado());

            // Adiciona a criatura na lista de criaturas
            Personagem tesouro = new Tesouro(new Ponto2D(x, y)); 
            personagens.add(tesouro);
        }
        return this;
    }
    
    public Mundo build() {
        return new Mundo(mapa, personagens);
    }
}
