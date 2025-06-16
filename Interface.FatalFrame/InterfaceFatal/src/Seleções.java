public class Seleções {

    public void executarEscolha(int escolha) {

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
        } else {
            System.out.println("Opção inválida. Por favor, tente novamente.");
        }
    }
}
