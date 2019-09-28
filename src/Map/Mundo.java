package Map;


import Map.Celula;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Characters.*;
import Class.*;
import Entidades.*;

public class Mundo {

    private Celula[][] mapa;
    private List<Entidade> entidades;
    private Jogador jogador;

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Mundo(Celula[][] mapa, List<Entidade> entidades) {
        this.mapa = mapa;
        this.entidades = entidades;
    }

    public boolean bloqueado(int x, int y) {
        return mapa[x][y].isBloqueado();
    }

    public void atualizar() {
        jogador.atualizar(this);
        Entidade removeEntidade = new Entidade();
        for (Entidade entidade : entidades) {
            entidade.atualizar(this);
            if (entidade.posicao.getX() == jogador.posicao.getX()
                    && entidade.posicao.getY() == jogador.posicao.getY() && (entidade.getSimbolo() == Zumbi.SIMBOLO || entidade.getSimbolo() == Lobo.SIMBOLO)) {
                jogador.tomarDano(1);
            }
            if (entidade.posicao.getX() == jogador.posicao.getX()
                    && entidade.posicao.getY() == jogador.posicao.getY() && entidade.getSimbolo() == Chave.SIMBOLO) {
                jogador.pegaChave();
                removeEntidade = entidade;
            }
            if (entidade.posicao.getX() == jogador.posicao.getX()
                    && entidade.posicao.getY() == jogador.posicao.getY() && entidade.getSimbolo() == Portal.SIMBOLO && jogador.temChave()) {
            }
            if (entidade.posicao.getX() == jogador.posicao.getX()
                    && entidade.posicao.getY() == jogador.posicao.getY() && entidade.getSimbolo() == Tesouro.SIMBOLO) {
                jogador.pegaTesouro();
                removeEntidade = entidade;
            }

        }
        entidades.remove(removeEntidade);
    }

    public void desenhar() {

        // Criar um mapa de criaturas baseado em suas posições
        System.out.println("Vidas: " + jogador.getVidas());
        System.out.println("Ouro: " + jogador.getOuro());
        System.out.println("Andar: " + jogador.getAndar());
        System.out.println("Chave: " + jogador.getChave());
        Map<String, Entidade> map = new HashMap<>();
        for (Entidade entidade : entidades) {
            map.put(entidade.posicao.toString(), entidade);
        }

        // Adicionamos também o jogador no mapa
        map.put(jogador.posicao.toString(), jogador);

        for (int y = 0; y < mapa[0].length; y++) {
            for (int x = 0; x < mapa.length; x++) {
                Ponto2D posicao = new Ponto2D(x, y);
                if (map.containsKey(posicao.toString())) {
                    Entidade entidade = (Entidade) map.get(posicao.toString());
                    System.out.print(entidade);
                } else {
                    System.out.print(mapa[x][y].simbolo);
                }
            }
            System.out.println();
        }
    }
}
