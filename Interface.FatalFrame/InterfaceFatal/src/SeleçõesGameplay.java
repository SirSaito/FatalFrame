import java.util.Scanner;

public class SeleçõesGameplay extends Seleções {

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Escolha seu personagem:");
        System.out.println("1 - Mafuyu (Números)");
        System.out.println("2 - Miku (Frases)");

        int personagem = 0;
        while (personagem != 1 && personagem != 2) {
            try {
                System.out.print(">> ");
                personagem = Integer.parseInt(scanner.nextLine());
                if (personagem != 1 && personagem != 2) {
                    System.out.println("Escolha inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite 1 ou 2.");
            }
        }

        if (personagem == 1) {
            System.out.println("🔢 Você escolheu Mafuyu!");
        } else {
            System.out.println("📝 Você escolheu Miku!");
        }

        System.out.println("\nEscolha a dificuldade:");
        System.out.println("1 - Normal");
        System.out.println("2 - Difícil");

        int dificuldade = 0;
        while (dificuldade != 1 && dificuldade != 2) {
            try {
                System.out.print(">> ");
                dificuldade = Integer.parseInt(scanner.nextLine());
                if (dificuldade != 1 && dificuldade != 2) {
                    System.out.println("Escolha inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite 1 ou 2.");
            }
        }

        Jogador jogador;

        if (personagem == 1) {
            jogador = (dificuldade == 1) ? new JogadorNumerico(3) : new JogadorNumerico(5);
            ((Mafuyu) jogador).EscolherMafuyu();
        } else {
            jogador = (dificuldade == 1) ? new JogadorFrases(5, 1) : new JogadorFrases(5, 2);
            ((Miku) jogador).EscolherMiku();
        }

        Portas portas = new Portas(); // Composição
        int pontuacao = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.println("\n🚪 Porta " + i + ":");

            boolean venceu = portas.iniciarDesafio(jogador, i);
            if (venceu) {
                pontuacao++;
                System.out.println("✅ Você abriu a porta " + i + "!");
            } else {
                System.out.println("❌ Você perdeu na porta " + i + ". Jogo encerrado.");
                break;
            }
        }

        System.out.println("\n🏁 Fim de jogo. Pontuação final: " + pontuacao + " de 20");
    }
}
