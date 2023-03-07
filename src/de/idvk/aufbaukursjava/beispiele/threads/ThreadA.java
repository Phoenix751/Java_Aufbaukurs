package de.idvk.aufbaukursjava.beispiele.threads;

public class ThreadA extends Thread {

    @Override
    public void run() {

        while (true) {
            System.out.println("Hello");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
