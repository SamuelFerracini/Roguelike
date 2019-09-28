package Characters;

import Map.Mundo;
import Class.Ponto2D;
import Class.Personagem;
import java.util.Scanner;
import Entidades.Chave;

public class Jogador extends Personagem {

    private int vidas;
    private int passos;
    private boolean temChave;
    private Scanner entrada;
    private int ouro;
    private int andar;
    
    public Jogador(int vidas, Ponto2D posicao, char simbolo) {
        super(posicao, simbolo);
        this.vidas = vidas;
        this.passos = 0;
        this.temChave = false;
        this.ouro = 0;
        this.andar = 1;
        this.entrada = new Scanner(System.in);
    }
    
    public boolean temChave(){
        if(temChave)
            return true;
        return false;
    }

    public boolean vivo() {
        return vidas > 0;
    }

    public void tomarDano(int dano) {
        vidas -= dano;
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

    public void pegaChave() {
        temChave = true;
    }
    
    public String getChave(){
        return Boolean.toString(temChave);
    }
    
    public void pegaTesouro(){
        this.ouro += (int)Math.round(Math.random() * 1000);
    }

    public String getVidas() {
        return Integer.toString(vidas);
    }

    public String getOuro() {
          return Integer.toString(ouro);
    }

    public String getAndar() {
        return Integer.toString(andar);
    }

}
