package de.idvk.aufbaukursjava.synchronize;

import de.idvk.aufbaukursjava.beispiele.sync.SyncCounter;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterTest {

    @RepeatedTest(10)
    public void counterTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        SyncCounter counter = new SyncCounter();

        for (int i = 0; i < 1000; i++) {
            executorService.submit(counter::increase);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);

        assertEquals(1000, counter.getCounter());
    }

    @RepeatedTest(10)
    public void syncCounterTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        SyncCounter counter = new SyncCounter();

        for (int i = 0; i < 1000; i++) {
            executorService.submit(counter::syncIncrease);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);

        assertEquals(1000, counter.getCounter());
    }
}
