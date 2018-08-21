package ru.job4j.bomberMan;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

class Board {
    private final ReentrantLock[][] board;

   public Board(int x, int y) {
        board = new ReentrantLock[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    private boolean move(Cell source, Cell dist) throws InterruptedException {
        boolean result = dist.cellLock();
        if (result) {
            source.CellUnlock();
        }
        return result;
    }

    public void startGame(int x, int y) {
        Thread heroThread = new Thread() {
            Cell heroCell = new Cell(x, y, board[y][x]);

            @Override
            public void run() {
                try {
                    heroCell.cellLock();
                    while (true) {
                        Cell dist = newPosition(heroCell);
                        if (move(heroCell, dist)) {
                            heroCell = dist;
                            sleep(1000);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        heroThread.start();
    }

    private Cell newPosition(Cell source) {
        Random random = new Random();
        int x;
        int y;
        Cell result = source;
        boolean isNewCell = false;
        while (!isNewCell) {
            x = source.getX() + random.nextInt(2) * (random.nextBoolean() ? 1 : -1);
            y = source.getY() + random.nextInt(2) * (random.nextBoolean() ? 1 : -1);
            if (x > 0 && y > 0 && x < board[1].length && y < board.length && (x != source.getX() || y != source.getY())) {
                result = new Cell(x, y, board[y][x]);
                isNewCell = true;
            }
        }
        return result;
    }
}
