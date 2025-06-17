import java.util.*;

public class JogadorNumerico extends Time implements Jogador, Mafuyu {
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
    public boolean realizeDesiderio(int porta) {
        Random random = new Random();
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < numerosPorPorta * porta; i++) {
            numeros.add(random.nextInt(90) + 10); // Números de dois dígitos
        }

        System.out.println("🔢 Digite os " + (numerosPorPorta * porta) + " números exatamente como mostrados:");
        System.out.println(numeros);

        iniciarCronometro(20_000); // Inicia cronômetro de 60 segundos

        int tentativas = 3;
        while (tentativas > 0 && !tempoEsgotado) {
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

                if (correto) {
                    pararCronometro();
                    return true;
                }

                tentativas--;
                System.out.println("❌ Incorreto. Tentativas restantes: " + tentativas);
            } catch (Exception e) {
                System.out.println("⚠️ Entrada inválida.");
                tentativas--;
            }
        }

        pararCronometro();
        return false;
    }
}
