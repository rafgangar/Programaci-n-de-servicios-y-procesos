package semana1.ejercicio2;

import java.util.Random;

public class HiloPrimo implements Runnable {
    private String nombreHilo;

    public HiloPrimo(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    private boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        System.out.println(nombreHilo + " ha generado el número aleatorio: " + numeroAleatorio);

        for (int i = 1; i <= numeroAleatorio; i++) {
            if (esPrimo(i)) {
                System.out.println(nombreHilo + " encontró el número primo: " + i);
                try {
                    Thread.sleep(500 + random.nextInt(501));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

