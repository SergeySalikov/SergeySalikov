package ru.job4j.bomberMan;


import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Hero extends Thread {
    private final Board playBoard;
    private Lock lock;
    private Cell position;
    private Random random = new Random();

    Hero(Board board, int x, int y) {
        playBoard = board;
        position = new Cell(x, y);
        this.lock = board.getLock(position);
        this.start();
    }

    public void run() {
        Cell newPosition;
        Lock newLock;
        while (!isInterrupted()) {
            newPosition = getNewPosition();
            newLock = playBoard.getLock(newPosition);
            try {
                if (newLock.tryLock(500, TimeUnit.MILLISECONDS)) {
                    this.lock = newLock;
                    position = newPosition;
                    sleep(1000);
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }


    private Cell getNewPosition() {
        int x = 0;
        int y = 0;
        Cell result = position;
        while (x == 0 || y == 0 || x >= playBoard.getX() || y >= playBoard.getY() || result.equals(position)) {
            x = position.getX() + random.nextInt(2) * (random.nextBoolean() ? 1 : -1);
            y = position.getY() + random.nextInt(2) * (random.nextBoolean() ? 1 : -1);
            result = new Cell(x, y);
        }
        return result;
    }

    public void shutdown() {
        this.interrupt();
    }
}
