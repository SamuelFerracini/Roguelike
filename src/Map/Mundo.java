package Map;

import Map.Celula;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Characters.*;
import Class.*;
import Entidades.*;
import Class.Personagem;
import java.util.ArrayList;

public class Mundo {

    private Celula[][] mapa;
    private List<Personagem> personagens;
    private Jogador jogador;
    private int estado = 1; //  1 game -- 2 loja

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int valor) {
        this.estado = valor;
    }

    public Mundo(Celula[][] mapa, List<Personagem> personagens) {
        this.mapa = mapa;
        this.personagens = personagens;
    }

    public boolean bloqueado(int x, int y) {
        return this.mapa[x][y].isBloqueado();
    }

    public List<Personagem> getPersonagens() {
        return this.personagens;
    }

    public Jogador getJogador() {
        return this.jogador;
    }

    public int atualizar() {
        jogador.atualizar(this);
        List<Personagem> removeList = new ArrayList<Personagem>();
        Personagem tempPersonagem;
        for (Personagem personagem : personagens) {
            tempPersonagem = personagem.atualizar(this);
            if (tempPersonagem != null) {
                removeList.add(tempPersonagem);
            }
        }
        personagens.removeAll(removeList);
        return 0;
    }

    public void desenhar() {
        Tools.Tools.clearScreen();
        // Criar um mapa de criaturas baseado em suas posições
        System.out.print("Vidas: ");
        if (jogador.getQtdVidas() >= 5) {
            System.out.print("GOD MODE");
        } else {
            for (int i = 0; i < jogador.getQtdVidas(); i++) {
                System.out.print("♥ ");
            }
            for (int i = 0; i < jogador.getNivelVitalidade() - jogador.getQtdVidas(); i++) {
                System.out.print("♡ ");
            }
            System.out.print(" Escudo: ");
            for (int i = 0; i < jogador.getQtdEscudo(); i++) {
                System.out.print("⍔ ");
            }
        }

//        System.out.println("Nivel Escudo: " + jogador.getNivelEscudo());
        System.out.println("Ouro: " + jogador.getQtdOuro());
        System.out.println("Andar: " + jogador.getNivelAndar());
        if (jogador.isTemRuna()) {
            System.out.println("R");
        }
//        System.out.println("Runa: " + jogador.isTemRuna());
        Map<String, Entidade> map = new HashMap<>();
        for (Entidade entidade : personagens) {
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
