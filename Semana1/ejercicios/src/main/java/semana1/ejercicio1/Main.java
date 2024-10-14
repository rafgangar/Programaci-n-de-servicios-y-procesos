package semana1.ejercicio1;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige modo de ejecución del programa: " +
                "1 -> clase como parametro, 2-> clase anónima, 3-> expresión lamba ");

        final int type = sc.nextInt();
        switch (type) {
            case 1:
                Thread t1 = new Thread(new PrinterNumber());
                t1.start();
                break;
            case 2:
                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            printNumeros();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                t2.start();
                break;
            case 3:
                Thread t3 = new Thread( () -> {
                    try {
                        printNumeros();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
                t3.start();
                break;
                
            default:
                break;

        }

    }

    private static void printNumeros() throws InterruptedException {
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
            Thread.sleep(numRandom);
        }
    }
}