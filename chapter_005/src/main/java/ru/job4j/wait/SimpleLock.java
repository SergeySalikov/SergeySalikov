package ru.job4j.wait;


public class SimpleLock {
    private boolean locked = false;
    private final Object lock = new Object();

    public void lock() {
        synchronized (this.lock) {
            while (this.locked) {
                try {
                    this.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            locked = true;
        }
    }

    public void unlock() {
        synchronized (this.lock) {
            this.locked = false;
            lock.notify();
        }
    }
}
