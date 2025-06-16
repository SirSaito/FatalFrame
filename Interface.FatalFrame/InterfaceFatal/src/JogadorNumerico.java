import java.util.*;

public class JogadorNumerico implements Jogador, Mafuyu {
    private int numerosPorPorta;
    private Scanner scanner;

    public JogadorNumerico(int numerosPorPorta) {
        this.numerosPorPorta = numerosPorPorta;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void EscolherMafuyu() {
        System.out.println("🔢 Mafuyu pronto para o desafio com números!");
    }

    @Override
    public boolean realizarDesafio(int porta) {
        Random random = new Random();
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < numerosPorPorta * porta; i++) {
            numeros.add(random.nextInt(90) + 10); // dois dígitos
        }

        System.out.println("🔢 Digite os " + (numerosPorPorta * porta) + " números exatamente como mostrados:");
        System.out.println(numeros);

        long tempoLimite = System.currentTimeMillis() + 60_000; // 1 minuto
        int tentativas = 3;

        while (tentativas > 0 && System.currentTimeMillis() < tempoLimite) {
            try {
                System.out.print(">> ");
                String[] entrada = scanner.nextLine().trim().split(" ");
                if (entrada.length != numeros.size()) {
                    System.out.println("❌ Quantidade incorreta. Tente novamente.");
                    tentativas--;
                    continue;
                }

                boolean correto = true;
                for (int i = 0; i < numeros.size(); i++) {
                    if (Integer.parseInt(entrada[i]) != numeros.get(i)) {
                        correto = false;
                        break;
                    }
                }

                if (correto) return true;

                tentativas--;
                System.out.println("❌ Incorreto. Tentativas restantes: " + tentativas);
            } catch (Exception e) {
                System.out.println("⚠️ Entrada inválida.");
                tentativas--;
            }
        }

        System.out.println("⏱️ Tempo esgotado ou tentativas esgotadas.");
        return false;
    }
}
