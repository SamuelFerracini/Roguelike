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
        return this.mapa[x][y].isBloqueado();
    }

    public List<Entidade> getEntidades() {
        return this.entidades;
    }

    public Jogador getJogador() {
        return this.jogador;
    }

    public int atualizar() {
        jogador.atualizar(this);
        Entidade removeEntidade = new Entidade();
        for (Entidade entidade : entidades) {
            entidade.atualizar(this);

            // LOGICA DO ZUMBI COMENDO A GALERA
            if (entidade.getSimbolo() == Zumbi.SIMBOLO) {
                for (Entidade et : entidades) {
                    if ((et.getSimbolo() == Ovelha.SIMBOLO || et.getSimbolo() == Lobo.SIMBOLO)) {
                        if ((entidade.posicao.getX() == et.posicao.getX() && entidade.posicao.getY() == et.posicao.getY())) {
                            removeEntidade = et;
                        }
                    }
                }
                if (entidade.posicao.getX() == jogador.posicao.getX()
                        && entidade.posicao.getY() == jogador.posicao.getY()) {
                    jogador.tomarDano(1);
                    removeEntidade = entidade;
                }
            }
            // ---------------------------------- FIM ----------------------------------

            // LOGICA DO JOGADOR PEGAR A CHAVE OU O TESOURO
            if (entidade.simbolo == Chave.SIMBOLO || entidade.simbolo == Tesouro.SIMBOLO) {
                if (entidade.posicao.getX() == jogador.posicao.getX()
                        && entidade.posicao.getY() == jogador.posicao.getY()) {
                    if (entidade.simbolo == Chave.SIMBOLO) {
                        jogador.setChave();

                    } else {
                        jogador.setTesouro();

                    }
                    removeEntidade = entidade;
                }
            }
            // ---------------------------------- FIM ----------------------------------

            // LOGICA DO JOGADOR ENTRAR NO PORTAL
            if (entidade.simbolo == Portal.SIMBOLO) {
                if (entidade.posicao.getX() == jogador.posicao.getX()
                        && entidade.posicao.getY() == jogador.posicao.getY() && jogador.temChave()) {
                    jogador.setAndar();
                    return 2;
                }
            }
            // ---------------------------------- FIM ----------------------------------

        }
        entidades.remove(removeEntidade);
        return 0;
    }

    public void desenhar() {

        // Criar um mapa de criaturas baseado em suas posições
        System.out.println("Vidas: " + jogador.getVidas());
        System.out.println("Escudo: " + jogador.getEscudo());
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
