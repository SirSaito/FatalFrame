import java.util.Random;

public class Dica {

    private String[] dicas = {
            "💡 Dica: Toda foto guarda um segredo — ou liberta um espírito",
            "💡 Dica: O número 42 pode abrir algo escondido.",
            "💡 Dica: Na Mansão Himuro, o passado não descansa..",
            "💡 Dica: Um clique pode revelar a verdade... ou selar seu destino..",
            "💡 Dica: Miku carrega a última chance de salvar seu irmão..",
            "💡 Dica: Entre sombras e sussurros, cada corredor é um aviso."
    };

    public void mostrarDicaAleatoria() {
        Random rand = new Random();
        int indice = rand.nextInt(dicas.length);
        System.out.println("\n" + dicas[indice] + "\n");
    }
}
