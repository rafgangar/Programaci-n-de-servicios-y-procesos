package org.ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de hilos que deseas lanzar: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            String nombreHilo = "Hilo " + i;
            Thread hilo = new Thread(new HiloPrimo(nombreHilo));
            hilo.start();
        }
    }
}