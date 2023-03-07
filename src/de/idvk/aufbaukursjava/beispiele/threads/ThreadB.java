package de.idvk.aufbaukursjava.beispiele.threads;

import static java.lang.Thread.sleep;

public class ThreadB implements Runnable {
    @Override
    public void run() {

        while (true) {
            System.out.println("World");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
