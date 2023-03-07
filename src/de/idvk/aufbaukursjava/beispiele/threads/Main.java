package de.idvk.aufbaukursjava.beispiele.threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        new ThreadA().start();

        new Thread(new ThreadB()).start();

        while (true) {
            System.out.println("!");
            Thread.sleep(1500);
        }
    }
}
