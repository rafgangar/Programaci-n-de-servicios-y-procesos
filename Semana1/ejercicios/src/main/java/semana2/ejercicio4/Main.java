package semana2.ejercicio4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int objetivo = random.nextInt(11) + 10;
        System.out.println("Pulsa enter cuando creas que el contador ha llegado a " + objetivo);

        Contador contador = new Contador();
        Thread hiloContador = new Thread(contador);
        hiloContador.start();

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
            System.out.println("¡Lo has conseguido!");
        } else {
            System.out.println("Vuelve a intentarlo, has detenido el contador en: " + objetivo);
        }
    }
}
