import java.io.*;

public class Seleções {

    private Dica dica = new Dica(); // Agregação

    public void executarEscolha(int escolha) {
        dica.mostrarDicaAleatoria(); // Exibe uma dica misteriosa antes da ação

        if (escolha == 1) {
            System.out.println("Start Game!");
            SeleçõesGameplay gameplay = new SeleçõesGameplay();
            gameplay.iniciarJogo();
        } else if (escolha == 2) {
            System.out.println("\nSINOPSE:\n");
            System.out.println("Movidos por uma inquietação que vai além da simples curiosidade, o aspirante a jornalista Mafuyu Hinasaki e sua irmã, Miku, seguem os rastros do renomado romancista Junsei Takamine, desaparecido misteriosamente enquanto investigava a sinistra Mansão Himuro — um local envolto em lendas sangrentas, murmúrios de antigos rituais e ecos de gritos esquecidos pelo tempo.\n" +
                    "...\nCada fotografia pode capturar mais do que uma imagem: pode aprisionar uma alma. Porque naquela mansão, onde antes as fotos guardavam memórias de família... agora, cada clique pode se tornar seu último. Cada imagem... um Fatal Frame.");
        } else if (escolha == 3) {
            System.out.println("Saindo do pesadelo.... até breve");
        } else if (escolha == 42) {
            opcaoSecreta();
        } else {
            System.out.println("Opção inválida. Por favor, tente novamente.");
        }
    }

    private void opcaoSecreta() {
        System.out.println("\n✨ Você descobriu a opção secreta: Piada do programador Java ✨");
        System.out.println("🧠 Por que o programador Java foi ao terapeuta?");
        System.out.println("➡️ Porque ele tinha muitos problemas de classe e não conseguia resolver suas heranças!\n");

        System.out.println("Digite uma mensagem misteriosa (use '.' para encerrar):");

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileWriter writer = new FileWriter("mensagem_secreta.txt");

            char c;
            do {
                c = (char) br.read();
                writer.write(c);
            } while (c != '.');

            writer.close();

            System.out.println("\n📁 Texto gravado em 'mensagem_secreta.txt'!");
            System.out.println("🔍 Lendo conteúdo do arquivo:\n");

            BufferedReader fileReader = new BufferedReader(new FileReader("mensagem_secreta.txt"));
            int ch;
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char) ch);
            }

            fileReader.close();
            System.out.println("\n\n🧾 Fim da leitura misteriosa.");

        } catch (IOException e) {
            System.out.println("❌ Erro ao acessar o arquivo: " + e.getMessage());
        }
    }
}
