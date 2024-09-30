package semana2.ejercicio4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int objetivo = random.nextInt(11) + 10;
        System.out.println("Intenta detener el contador cuando llegue al número: " + objetivo);

        Contador contador = new Contador();
        Thread hiloContador = new Thread(contador);
        hiloContador.start();

        System.out.println("Presiona Enter para detener el contador...");
        scanner.nextLine();

        contador.detener();

        try {
            hiloContador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int numeroFinal = contador.getNumeroActual() - 1;
        System.out.println("El contador se detuvo en: " + numeroFinal);

        if (numeroFinal == objetivo) {
            System.out.println("¡Felicidades! Has detenido el contador en el número exacto.");
        } else {
            System.out.println("Lo siento, no fue el número correcto. El número objetivo era: " + objetivo);
        }
    }
}
