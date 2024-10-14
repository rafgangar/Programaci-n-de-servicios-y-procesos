package semana3.ejercicio6;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Log {

    PrintWriter printWriter = null;

    public Log() {
        try {
            printWriter = new PrintWriter(new FileWriter("./Files/log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribir(int id, String cadena) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd ");
        LocalDateTime now = LocalDateTime.now();

        printWriter.println("ID: " + id + " - " + dtf.format(now));

        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(51));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Escribimos la línea
        printWriter.println(cadena);
    }

    public void cerrar() {
        if (printWriter != null) {
            printWriter.close();
        }
    }
}