package ru.job4j.bomberMan;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private ReentrantLock lock;
    private int x;
    private int y;

    Cell(int x, int y, ReentrantLock lock) {
        this.x = x;
        this.y = y;
        this.lock = lock;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    boolean cellLock() throws InterruptedException {
        return this.lock.tryLock(500, TimeUnit.MILLISECONDS);
    }

    void CellUnlock() {
        this.lock.unlock();
    }
}
