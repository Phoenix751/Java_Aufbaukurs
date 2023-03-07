package de.idvk.aufbaukursjava.beispiele.sync;

public class SyncCounter {
    private int counter = 0;

    public void increase() {
        setCounter(getCounter() + 1);
    }

    public synchronized void syncIncrease() {
        setCounter(getCounter() + 1);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
