package de.idvk.aufbaukursjava.beispiele.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(10);

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            executorService.execute(new User(semaphore, "User " + i));
        }

        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
