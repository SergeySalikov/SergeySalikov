package ru.job4j.bomberMan;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Board {
    final private Lock[][] board;
    private int x;
    private int y;

    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        board = new ReentrantLock[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    boolean move(Cell source, Cell dist) {
        return true;
    }

    Lock getLock(Cell cell) {
        return board[cell.getY()][cell.getX()];
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
