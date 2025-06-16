import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Seleções selecao = new Seleções();

        boolean menuAtivo = true;

        for (; menuAtivo;) {
            System.out.println(" _______  _______ _________ _______  _          _______  _______  _______  _______  _______ ");
            System.out.println("(  ____ \\(  ___  )\\__   __/(  ___  )( \\        (  ____ \\(  ____ )(  ___  )(       )(  ____ \\");
            System.out.println("| (    \\/| (   ) |   ) (   | (   ) || (        | (    \\/| (    )|| (   ) || () () || (    \\/");
            System.out.println("| (__    | (___) |   | |   | (___) || |        | (__    | (____)|| (___) || || || || (__    ");
            System.out.println("|  __)   |  ___  |   | |   |  ___  || |        |  __)   |     __)|  ___  || |(_)| ||  __)   ");
            System.out.println("| (      | (   ) |   | |   | (   ) || |        | (      | (\\ (   | (   ) || |   | || (      ");
            System.out.println("| )      | )   ( |   | |   | )   ( || (____/\\  | )      | ) \\ \\__| )   ( || )   ( || (____/\\");
            System.out.println("|/       |/     \\|   )_(   |/     \\|(_______/  |/       |/   \\__/|/     \\||/     \\|(_______/");
            System.out.println("                                                                                           ");
            System.out.println("▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁");
            System.out.println(" ▶▶▶▶▶ Start Game ➔ 1 ◀◀◀◀◀");
            System.out.println(" ▶▶▶▶▶ History ➔ 2 ◀◀◀◀◀");
            System.out.println(" ▶▶▶▶▶ Exit ➔ 3 ◀◀◀◀◀");
            System.out.println("▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁▁");
            System.out.print("Escolha o número da sua escolha: ");

            int escolha = scanner.nextInt();

            selecao.executarEscolha(escolha);

            if (escolha == 1 || escolha == 3) {
                // Encerra o menu após iniciar jogo ou sair
                menuAtivo = false;
            }

            System.out.println(); // Espaço entre menus
        }

        scanner.close();
    }
}
