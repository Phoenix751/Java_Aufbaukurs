package de.idvk.aufbaukursjava.beispiele.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        SyncCounter counter = new SyncCounter();

        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Thread() {
                @Override
                public void run() {
                    counter.increase();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        assert (1000 == counter.getCounter());


    }
}
