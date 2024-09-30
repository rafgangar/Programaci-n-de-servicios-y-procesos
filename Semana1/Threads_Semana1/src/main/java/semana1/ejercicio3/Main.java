package semana1.ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de hilos a crear: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            String nombreHilo = "Hilo " + i;
            Thread hilo = new Thread(new HiloPrimo(nombreHilo), nombreHilo);
            hilo.start();

            while (hilo.getState() != Thread.State.TERMINATED) {
                System.out.println(
                        "ID: " + hilo.getId() + ", Nombre: " + hilo.getName() + ", Estado: " + hilo.getState());
                Thread.sleep(1000);
            }
        }

    }
}
