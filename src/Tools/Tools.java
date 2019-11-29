package Tools;

import Characters.Jogador;
import Class.Ponto2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tools {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void mostrarMorte() {
        clearScreen();
        System.out.println("          .'''''.        ..||..'''''''...");
        System.out.println("         / ##### \\       : ||            ''.");
        System.out.println("        | ## # ## |      :.||...''''''....  '.");
        System.out.println("        | #  #  # |        ||             ''''");
        System.out.println("        | ####### |     .  ||      VOCÊ ");
        System.out.println("         \\ ##### /     /| < _>       MORREU");
        System.out.println("          \\ ### /     / |/ < _>");
        System.out.println("        ..''   ''... /  |  < _>");
        System.out.println("      .'            /   | /||");
        System.out.println("      '                 |/ ||");
        System.out.println("      |   |     '..     |  ||");
        System.out.println("      |   |     |  '...''  ||");
        System.out.println("      |  |       |         ||");
        System.out.println("       \\ |       |         ||");
        System.out.println("       |\\|       |         ||");
        System.out.println("       \\|         |        ||");
        System.out.println("        |         |        ||");
        System.out.println("        |         |        ||");
        System.out.println("       |           |       ||");
        System.out.println("     __|           |__     ||");
        System.out.println("    /   '.........'   \\    ||");
        System.out.println("     ''''''     ''''''     ##");
        System.out.println("");
        System.out.println("");
        System.out.println("Você deseja se aventurar novamente?");

    }

    public static void mostraLogoJogo() {
        clearScreen();
        System.out.println("                 _______    ______    ______   __    __  ________  __        ______  __    __  ________ ");
        System.out.println("                |       \\  /      \\  /      \\ |  \\  |  \\|        \\|  \\      |      \\|  \\  /  \\|        \\");
        System.out.println("                | $$$$$$$\\|  $$$$$$\\|  $$$$$$\\| $$  | $$| $$$$$$$$| $$       \\$$$$$$| $$ /  $$| $$$$$$$$");
        System.out.println("                | $$__| $$| $$  | $$| $$ __\\$$| $$  | $$| $$__    | $$        | $$  | $$/  $$ | $$__    ");
        System.out.println("                | $$    $$| $$  | $$| $$|    \\| $$  | $$| $$  \\   | $$        | $$  | $$  $$  | $$  \\   ");
        System.out.println("                | $$$$$$$\\| $$  | $$| $$ \\$$$$| $$  | $$| $$$$$   | $$        | $$  | $$$$$\\  | $$$$$   ");
        System.out.println("                | $$  | $$| $$__/ $$| $$__| $$| $$__/ $$| $$_____ | $$_____  _| $$_ | $$ \\$$\\ | $$_____ ");
        System.out.println("                | $$  | $$ \\$$    $$ \\$$    $$ \\$$    $$| $$     \\| $$     \\|   $$ \\| $$  \\$$\\| $$     \\");
        System.out.println("                \\$$   \\$$  \\$$$$$$   \\$$$$$$   \\$$$$$$  \\$$$$$$$$ \\$$$$$$$$ \\$$$$$$ \\$$   \\$$ \\$$$$$$$$");
        System.out.println("");
        System.out.println("");
    }

    public static void mostrarCreditos() {

    }

    public static void salvaDadosJogador(Jogador jogador) {
        try {
            FileWriter writer = new FileWriter("dadosJogador.txt");
            writer.write(jogador.getQtdVidas() + ";");
            writer.write(jogador.getNivelVitalidade() + ";");
            writer.write(jogador.getQtdOuro() + ";");
            writer.write(jogador.getNivelAndar() + ";");
            writer.write(jogador.getNivelEscudo() + ";");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jogador importaDados() {
        String[] dados = leArquivo();
        if (dados.length != 0) {
            Jogador jogadorImportado = new Jogador(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]),
                    false, false, Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Integer.parseInt(dados[4]),
                    new Ponto2D(0,0));
            return jogadorImportado;
        }

        return null;
    }

    private static String[] leArquivo() {
        try {
            FileReader reader = new FileReader("dadosJogador.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            String dados = "";
            while ((line = bufferedReader.readLine()) != null) {
                dados = line;
            }
            reader.close();
            String[] dadosJogador = dados.split(";");
            return dadosJogador;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
