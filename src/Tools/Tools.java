package Tools;

import java.util.Scanner;

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
    
    public static void mostrarCreditos(){
        
    }

}
