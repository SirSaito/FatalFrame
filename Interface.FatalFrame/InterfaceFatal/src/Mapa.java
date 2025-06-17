import java.util.Scanner;

public class Mapa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Portas portas = new Portas(); // Composição: Mapa contém Portas


        System.out.print("Escolha a dificuldade (1 = Normal, 2 = Difícil): ");

        int dificuldade = 1;
        try {
            dificuldade = Integer.parseInt(scanner.nextLine());
            if (dificuldade != 1 && dificuldade != 2) throw new IllegalArgumentException();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Dificuldade normal selecionada por padrão.");
            dificuldade = 1;
        }

        Jogador jogador;
        if (dificuldade == 1) {
            jogador = new JogadorNumerico(3);
        } else {
            jogador = new JogadorFrases(5, 2);
        }

        int pontuacao = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.println("\n🚪 Porta " + i + ":");

            boolean venceu = portas.iniciarDesafio(jogador, i);
            if (venceu) {
                pontuacao++;
                System.out.println("✅ Você abriu a porta " + i + "!");
            } else {
                System.out.println("❌ Você perdeu na porta " + i + ". Jogo finalizado.");
                break;
            }
        }

        System.out.println("\n🏁 Fim de jogo. Pontuação: " + pontuacao + "/20" + "OBRIGADO POR JOGAR!");
        scanner.close();
    }
}
