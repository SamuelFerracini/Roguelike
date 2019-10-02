package Class;

import Characters.Jogador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {

    private List<Produto> produtos = new ArrayList<Produto>();
    private Jogador jogador;

    public Loja(Jogador jogador) {
        this.jogador = jogador;
        int valorEscudo = this.jogador.getEscudo() * 1500;
        int valorCoracao = this.jogador.getCoracoes() * 750;
        this.produtos.add(new Produto("Poção de cura", 1, 1000));
        this.produtos.add(new Produto("Slot de coração", 1, valorCoracao));
        this.produtos.add(new Produto("Aprimorar escudo", 1, valorEscudo));
        this.produtos.add(new Produto("Runa infinita", 1, 10000));
        this.produtos.add(new Produto("God mode", 1, 20000));
        

    }

    public void mostraProdutos() {
        int i = 1;
        for (Produto produto : this.produtos) {
            System.out.println(i + ". " + produto.toString());
            i++;
        }
        System.out.println("Você comprar qual produto? (0 sair) ");
        Scanner sc = new Scanner(System.in);
        int resposta = sc.nextInt();
        if (resposta == 0) {
            return;
        }
        int posicaoProduto = resposta - 1;
        Produto produtoComprado = produtos.get(posicaoProduto);
        if (jogador.getOuro() < produtoComprado.getPreco()) {
            System.out.println("Ouro insuficiente para comprar o produto");
            return;
        }
        int valorGasto = jogador.getOuro() - produtoComprado.getPreco();
        switch (resposta) {
            case 1:
                if(jogador.getVidas() == jogador.getCoracoes()){
                    return;
                }
                jogador.setVidas(jogador.getVidas() + 1);
                break;
            case 2:
                jogador.setOuro(valorGasto);
                jogador.setCoracoes(jogador.getCoracoes() + 1);
                break;
            case 3:
                if(this.jogador.getEscudo() == 3){
                    return;
                }
                jogador.setOuro(valorGasto);
                jogador.setEscudo(1);
                break;
            case 4:
//               jogador.setChave();
                break;
            case 5:
                jogador.setOuro(valorGasto);
                jogador.setCoracoes(99999999);
                jogador.setVidas(99999999);
                break;
        }
        System.out.println("Obrigado por comprar!");
        return;
    }

    public void mostraLoja() {
        System.out.println("      ('");
        System.out.println("        '|");
        System.out.println("        |'");
        System.out.println("       [::]");
        System.out.println("       [::]   _......_");
        System.out.println("       [::].-'      _.-`.");
        System.out.println("       [:.'    .-. '-._.-`.");
        System.out.println("       [/ /\\   |  \\        `-..");
        System.out.println("       / / |   `-.'      .-.   `-.");
        System.out.println("      /  `-'            (   `.    `.");
        System.out.println("     |           /\\      `-._/      \\");
        System.out.println("     '    .'\\   /  `.           _.-'|");
        System.out.println("    /    /  /   \\_.-'        _.':;:/");
        System.out.println("  .'     \\_/             _.-':;_.-'");
        System.out.println(" /   .-.             _.-' \\;.-'");
        System.out.println("/   (   \\       _..-'     |");
        System.out.println("\\    `._/  _..-'    .--.  |");
        System.out.println(" `-.....-'/  _ _  .'    '.|");
        System.out.println("          | |_|_| |      | \\  (o)");
        System.out.println("     (o)  | |_|_| |      | | (\\'/)");
        System.out.println("   (\\'/)/| ''''' |     o|   \\;:;");
        System.out.println("     _____|____   |      |  |/)");
        System.out.println("    |          | _|_..--'\\.' ;:");
        System.out.println("    |   Loja   |-' :;   :;");
        System.out.println("    |__________|");
        System.out.println("         |_|");
        System.out.println("         |_|");
        System.out.println("         |_|");

    }
}
