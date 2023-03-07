package de.idvk.aufbaukursjava.beispiele.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class User implements Runnable {
    private final Semaphore semaphore;
    private boolean loggedIn = false;
    private final String username;

    public User(Semaphore semaphore,
                String username) {
        this.semaphore = semaphore;
        this.username = username;
    }

    @Override
    public void run() {
        while (true) {
            if (loggedIn) {
                if (new Random().nextInt(100) < 80) {
                    semaphore.release();
                    System.out.println(username + " ausgeloggt");
                    loggedIn = !loggedIn;
                }
            } else {
                try {
                    semaphore.acquire();
                    System.out.println(username + " login");
                    loggedIn = !loggedIn;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
