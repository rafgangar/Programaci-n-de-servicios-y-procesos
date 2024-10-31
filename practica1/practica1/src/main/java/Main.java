import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            final int carrilId = i;
            executor.submit(() -> {
                Carril carril = new Carril(carrilId);
                Corredor[] corredores = new Corredor[4];
                for (int j = 0; j < 4; j++) {
                    corredores[j] = new Corredor(j, carril);
                    carril.añadirCorredor(corredores[j], j * 100000);
                }
                for (Corredor corredor : corredores) {
                    corredor.start();
                }
                try {
                    for (Corredor corredor : corredores) {
                        corredor.join();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }
}
