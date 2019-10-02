package Characters;

import Map.Mundo;
import Class.*;
import java.util.Scanner;
import Entidades.Runa;

public class Jogador extends Personagem {

    private int vidas;
    private int passos;
    private int coracoes;
    private boolean temChave;
    private Scanner entrada;
    private int ouro;
    private int andar;
    private int escudo;
    public static final char SIMBOLO = 'J';

    public Jogador(int vidas, int coracoes, int escudo, Boolean temChave, Ponto2D posicao) {
        super(posicao, SIMBOLO);
        this.vidas = vidas;
        this.passos = 0;
        this.temChave = temChave;
        this.ouro = 1000000;
        this.andar = 1;
        this.coracoes = coracoes;
        this.escudo = escudo;
        this.entrada = new Scanner(System.in);
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
    public Jogador(int vidas, Ponto2D posicao, int ouro, int andar, int escudo, int coracoes) {
        super(posicao, 'J');
        this.vidas = vidas;
        this.passos = 0;
        this.temChave = false;
        this.escudo = escudo;
        this.ouro = 1000000;
        this.andar = andar;
        this.entrada = new Scanner(System.in);
        this.coracoes = coracoes;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public boolean temChave() {
        if (temChave) {
            return true;
        }
        return false;
    }

    public void setCoracoes(int coracoes) {
        this.coracoes = coracoes;
    }

    public int getCoracoes() {
        return coracoes;
    }

    public boolean vivo() {
        return vidas > 0;
    }

    public void tomarDano(int dano) {
        if(escudo > 0){
            escudo -= dano;
        }else{
                vidas -= dano;
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

    public void setChave() {
        temChave = true;
    }

    public String getChave() {
        return Boolean.toString(temChave);
    }

    public void setTesouro() {
        this.ouro += (int) Math.round(Math.random() * 1000);
    }

    public int getVidas() {
        return this.vidas;
    }

    public int getOuro() {
        return this.ouro;
    }

    public int getAndar() {
        return this.andar;
    }

    public void setAndar() {
        this.andar += 1;
    }

    public int getEscudo() {
        return this.escudo;
    }
    
    public void setEscudo(int valorEscudo){
        this.escudo += valorEscudo;
    }

}
