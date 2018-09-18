package ru.job4j.bomberMan;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private final ReentrantLock lock;
    private final int x;
    private final int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.lock = new ReentrantLock();
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    boolean cellLock() throws InterruptedException {
        return this.lock.tryLock(5000, TimeUnit.MILLISECONDS);
    }

    void CellUnlock() {
        this.lock.unlock();
    }
}
