import java.util.Scanner;

public class Mapa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Portas portas = new Portas("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");

        System.out.println("🏰 Você está de frente para a Mansão, não ha para onde fugir, entre agora!");

        for (int i = 1; i <= 20; i++) {
            String mensagemEsperada = switch (i) {
                case 1 -> portas.getPorta1();
                case 2 -> portas.getPorta2();
                case 3 -> portas.getPorta3();
                case 4 -> portas.getPorta4();
                case 5 -> portas.getPorta5();
                case 6 -> portas.getPorta6();
                case 7 -> portas.getPorta7();
                case 8 -> portas.getPorta8();
                case 9 -> portas.getPorta9();
                case 10 -> portas.getPorta10();
                case 11 -> portas.getPorta11();
                case 12 -> portas.getPorta12();
                case 13 -> portas.getPorta13();
                case 14 -> portas.getPorta14();
                case 15 -> portas.getPorta15();
                case 16 -> portas.getPorta16();
                case 17 -> portas.getPorta17();
                case 18 -> portas.getPorta18();
                case 19 -> portas.getPorta19();
                case 20 -> portas.getPorta20();
                default -> "";
            };

            System.out.println("\n🚪 Porta " + i);
            System.out.println("Digite exatamente: \"" + mensagemEsperada + "\"");

            System.out.print(">> ");
            String entrada = scanner.nextLine();

            if (!entrada.equals(mensagemEsperada)) {
                System.out.println("❌ Você errou! Fim de jogo na porta " + i);
                System.out.println("Mensagem correta era: \"" + mensagemEsperada + "\"");
                scanner.close();
                return;
            } else {
                System.out.println("✅ Correto! A porta " + i + " foi aberta.");
            }
        }

        System.out.println("\n🎉 Parabéns! Você passou por todas as 20 portas!");
        scanner.close();
    }
}
