package concurrencia;

import java.time.Duration;
import java.time.Instant;

public class ThreadRunnable {
    private static final Instant INCIO = Instant.now();

    public static void main(String[] args) {
        Runnable tarea = () -> {
            try {
                Log("Empieza la tarea");
                Thread.sleep(5000);
                Log("Termina la tarea");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread hilo = new Thread(tarea);
        hilo.start();

        try {
            Log("Se empiexa a esperar al hilo");
            hilo.join(3000);
            Log("Se termina de esperar el hilo");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void Log(Object mensaje) {
        System.out.println(String.format("%s [%s] %s",
                Duration.between(INCIO, Instant.now()), Thread.currentThread().getName(), mensaje.toString()));
    }
}
