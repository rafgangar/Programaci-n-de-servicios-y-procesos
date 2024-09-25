package org.example;

import java.util.Random;
import java.util.Scanner;

public class PrinterNumber implements Runnable{
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer número : ");
        final int n1 = sc.nextInt();
        System.out.println("Introduce el segundo número : ");
        final int n2 = sc.nextInt();
        System.out.println("El hilo se ha lanzado : ");
        Random random = new Random();
        int numRandom = random.nextInt(1000);
        final int menor = Math.min(n1, n2);
        final int mayor = Math.max(n1, n2);
        for (int i = menor; i <= mayor; i++) {
            System.out.println("i = " + i);
            try {
                Thread.sleep(numRandom);
                System.out.println("Hilo interrumpido : ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
