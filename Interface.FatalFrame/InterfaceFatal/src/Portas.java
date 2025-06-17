import java.util.concurrent.*;

public class Portas {

    public boolean iniciarDesafio(Jogador jogador, int portaAtual) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Boolean> futuro = executor.submit(() -> jogador.realizeDesiderio(portaAtual));

        try {
            return futuro.get(1, TimeUnit.MINUTES); // 2 minutos de limite
        } catch (TimeoutException e) {
            System.out.println("⏰ Tempo esgotado!");
            futuro.cancel(true);
            return false;
        } catch (Exception e) {
            System.out.println("⚠️ Ocorreu um erro: " + e.getMessage());
            return false;
        } finally {
            executor.shutdownNow();
        }
    }
}
