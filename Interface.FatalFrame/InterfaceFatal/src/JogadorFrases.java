import java.util.*;

public class JogadorFrases implements Jogador, Miku {
    private int frasesPorPorta;
    private int palavrasPorFrase;
    private Scanner scanner;

    private static final String[] temas = {
            "A escuridão tomou conta da sala",
            "O vento sussurrava entre as frestas",
            "Algo se arrasta pelo chão úmido",
            "A presença está mais próxima",
            "Os olhos brilham na penumbra",
            "O ritual não pode ser interrompido",
            "O espelho revelou a verdade",
            "O silêncio é perturbador",
            "As paredes murmuram segredos",
            "A porta se fechou sozinha"
    };

    public JogadorFrases(int palavrasPorFrase, int frasesPorPorta) {
        this.palavrasPorFrase = palavrasPorFrase;
        this.frasesPorPorta = frasesPorPorta;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void EscolherMiku() {
        System.out.println("📝 Miku pronta para digitar frases de suspense!");
    }

    @Override
    public boolean realizarDesafio(int porta) {
        Random random = new Random();
        List<String> frases = new ArrayList<>();

        for (int i = 0; i < frasesPorPorta * porta; i++) {
            frases.add(temas[random.nextInt(temas.length)]);
        }

        // 📝 Exibir todas as frases na mesma linha separadas por " | "
        System.out.println("📝 Digite exatamente todas as frases na mesma linha:");
        String desafio = String.join(" | ", frases);
        System.out.println(desafio);

        long tempoLimite = System.currentTimeMillis() + 60_000; // 1 minuto
        int tentativas = 3;

        while (tentativas > 0 && System.currentTimeMillis() < tempoLimite) {
            System.out.print(">> ");
            String entrada = scanner.nextLine();

            if (entrada.equals(desafio)) {
                return true;
            } else {
                tentativas--;
                System.out.println("❌ Incorreto. Tentativas restantes: " + tentativas);
            }
        }

        System.out.println("⏱️ Tempo esgotado ou tentativas esgotadas.");
        return false;
    }
}
