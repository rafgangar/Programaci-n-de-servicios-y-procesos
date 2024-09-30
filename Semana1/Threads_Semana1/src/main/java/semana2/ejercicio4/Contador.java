package semana2.ejercicio4;

import java.util.Random;
import java.util.Scanner;

class Contador implements Runnable {
    private volatile boolean detenido = false;
    private int numeroActual = 1;

    public void detener() {
        detenido = true;
    }

    public int getNumeroActual() {
        return numeroActual;
    }

    @Override
    public void run() {
        try {
            while (!detenido) {
                if (numeroActual <= 5) {
                    System.out.println("Contador: " + numeroActual);
                }
                numeroActual++;
                Thread.sleep(1000); // Espera de 1 segundo entre números
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

