package Characters;

import Map.Mundo;
import Class.*;
import java.util.Scanner;
import Entidades.Runa;

public class Jogador extends Personagem {

    private int passos;
    private int qtdVidas;
    private int nivelVitalidade;
    private boolean temRuna;
    private int qtdEscudo;
    private int nivelEscudo;
    private int qtdOuro;
    private int nivelAndar;
    private Scanner entrada;
    public static final char SIMBOLO = 'J';

    // CRIA O JOGADOR A PRIMEIRA VEZ
    public Jogador(Ponto2D posicao) {
        super(posicao, SIMBOLO);
        this.qtdVidas = 3;
        this.nivelVitalidade = 3;
        this.passos = 2000;
        this.temRuna = false;
//        this.qtdOuro = 0;
        this.qtdOuro = 1000000;
        this.nivelAndar = 1;
        this.nivelEscudo = 1;
        this.qtdEscudo = nivelEscudo * 2;
        this.entrada = new Scanner(System.in);
    }

    public Jogador(int qtdVidas, int nivelVitalidade, Boolean temRuna, int qtdOuro, int nivelAndar, int nivelEscudo, Ponto2D posicao) {
        super(posicao, SIMBOLO);
        this.qtdVidas = qtdVidas;
        this.nivelVitalidade = nivelVitalidade;
        this.passos = 2000;
        this.temRuna = temRuna;
        this.qtdOuro = qtdOuro;
        this.nivelAndar = nivelAndar;
        this.nivelEscudo = nivelEscudo;
        this.qtdEscudo = nivelEscudo * 2;
        this.entrada = new Scanner(System.in);
    }

    public int getQtdVidas() {
        return this.qtdVidas;
    }

    public void setQtdVidas(int qtdVidas) {
        this.qtdVidas = qtdVidas;
    }
    
    public void incrementaQtdVidas(int qtdVidas) {
        this.qtdVidas += qtdVidas;
    }

    public int getQtdOuro() {
        return this.qtdOuro;
    }

    public void setQtdOuro(int qtdOuro) {
        this.qtdOuro = qtdOuro;
    }

    public void incrementaOuroAleatorio() {
        this.qtdOuro += (int) Math.round(Math.random() * 1000);
    }

    public int getNivelVitalidade() {
        return this.nivelVitalidade;
    }

    public void setNivelVitalidade(int nivelVitalidade) {
        this.nivelVitalidade = nivelVitalidade;
    }
    
    public void incrementaNivelVitalidade(int qtdNivelVitalidade) {
        this.nivelVitalidade += qtdNivelVitalidade;
    }

    public boolean isTemRuna() {
        return this.temRuna;
    }

    public void setTemRuna() {
        this.temRuna = true;
    }

    public int getNivelAndar() {
        return this.nivelAndar;
    }

    public void setNivelAndar(int nivelAndar) {
        this.nivelAndar = nivelAndar;
    }
    
    public void incrementaNivelAndar(int qtdNiveisAndar){
        this.nivelAndar += qtdNiveisAndar;
    }

    public int getNivelEscudo() {
        return this.nivelEscudo;
    }
    
    public void setNivelEscudo(int nivelEscudo){
        this.nivelEscudo = nivelEscudo;
    }
    
    public void incrementaNivelEscudo(int qtdNiveisEscudo){
    this.nivelEscudo += qtdNiveisEscudo;
    }

    public int getQtdEscudo() {
        return this.qtdEscudo;
    }

    public boolean vivo() {
        return this.qtdVidas > 0;
    }

    public void tomarDano(int dano) {
        if (qtdEscudo > 0) {
            qtdEscudo -= dano;
        } else {
            qtdVidas -= dano;
        }
    }

    @Override
    public void atualizar(Mundo mundo) {
        System.out.print("[A/W/S/D]: ");
        String comando = entrada.nextLine();
        if (comando.toUpperCase().trim().equals("A")) {
            mover(mundo, -1, 0);
        }
        if (comando.toUpperCase().trim().equals("W")) {
            mover(mundo, 0, -1);
        }
        if (comando.toUpperCase().trim().equals("S")) {
            mover(mundo, 0, 1);
        }
        if (comando.toUpperCase().trim().equals("D")) {
            mover(mundo, 1, 0);
        }
        passos++;
    }

}
