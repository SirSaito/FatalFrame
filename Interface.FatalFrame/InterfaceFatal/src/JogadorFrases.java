import java.util.*;

public class JogadorFrases extends Time implements Jogador, Miku {
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
    public boolean realizeDesiderio(int porta) {
        Random random = new Random();
        List<String> frases = new ArrayList<>();

        for (int i = 0; i < frasesPorPorta * porta; i++) {
            frases.add(temas[random.nextInt(temas.length)]);
        }

        // 📝 Exibir todas as frases na mesma linha separadas por " | "
        System.out.println("📝 Digite exatamente todas as frases na mesma linha:");
        String desafio = String.join(" | ", frases);
        System.out.println(desafio);

        iniciarCronometro(45_000); // 60 segundos
        int tentativas = 3;

        while (tentativas > 0 && !tempoEsgotado) {
            System.out.print(">> ");
            String entrada = scanner.nextLine();

            if (entrada.equals(desafio)) {
                pararCronometro();
                return true;
            } else {
                tentativas--;
                System.out.println("❌ Incorreto. Tentativas restantes: " + tentativas);
            }
        }

        pararCronometro();
        System.out.println("⏱️ Tempo esgotado ou tentativas esgotadas.");
        return false;
    }
}
