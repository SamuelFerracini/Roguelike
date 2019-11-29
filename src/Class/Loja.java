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
        System.out.println("");
        System.out.println("Ouro: " + jogador.getQtdOuro());
        System.out.println("Vida: " + jogador.getQtdVidas());
        System.out.println("Quantidade de slots de vida: " + jogador.getNivelVitalidade());
        System.out.println("Nivel escudo: " + jogador.getNivelEscudo());
        System.out.println("");
        int valorEscudo = jogador.getNivelEscudo() * 1500;
        int valorCoracao = jogador.getNivelVitalidade() * 750;
        this.produtos.add(new Produto("Poção de cura", 1, 1000));
        this.produtos.add(new Produto("Slot de coração", 1, valorCoracao));
        this.produtos.add(new Produto("Aprimorar escudo", 1, valorEscudo));
        this.produtos.add(new Produto("Runa infinita", 1, 10000));
        this.produtos.add(new Produto("God mode", 1, 20000));
    }

    public Jogador mostraProdutos() {
        int i = 1;
        for (Produto produto : this.produtos) {
            System.out.println(i + ". " + produto.toString());
            i++;
        }
        System.out.println("Você comprar qual produto? (0 - Sair) ");
        Scanner sc = new Scanner(System.in);
        int resposta = sc.nextInt();
        if (resposta == 0) {
            return jogador;
        }
        int posicaoProduto = resposta - 1;
        Produto produtoComprado = produtos.get(posicaoProduto);
        if (jogador.getQtdOuro() < produtoComprado.getPreco()) {
            System.out.println("Ouro insuficiente para comprar o produto");
            return jogador;
        }
        int valorGasto = jogador.getQtdOuro() - produtoComprado.getPreco();
        switch (resposta) {
            case 1:
                if (jogador.getQtdVidas() == jogador.getNivelVitalidade()) {
                    return jogador;
                }
                jogador.incrementaQtdVidas(1);
                break;
            case 2:
                jogador.setQtdOuro(valorGasto);
                jogador.incrementaNivelVitalidade(1);
                break;
            case 3:
                if (this.jogador.getNivelEscudo() == 3) {
                    return jogador;
                }
                jogador.setQtdOuro(valorGasto);
                jogador.incrementaNivelEscudo(1);
                break;
            case 4:
                jogador.setTemRunaInfinita(true);
                break;
            case 5:
                jogador.setQtdOuro(valorGasto);
                jogador.setNivelVitalidade(99999999);
                jogador.setQtdVidas(99999999);
                break;
        }
        System.out.println("Obrigado por comprar!");
        return jogador;
    }

    public void mostraLoja() {
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
