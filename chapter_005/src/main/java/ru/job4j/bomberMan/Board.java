package ru.job4j.bomberMan;

import java.util.concurrent.locks.ReentrantLock;

class Board {
    final private Cell[][] board;

    Board(int x, int y) {
        board = new Cell[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                board[i][j] = new Cell(j, i, new ReentrantLock());
            }
        }
    }

    boolean move(Cell source, Cell dist) throws InterruptedException {
        boolean result = dist.cellLock();
        if (result) {
            source.CellUnlock();
        }
        return result;
    }

    Cell getCell(int x, int y) {
        return board[y][x];
    }

    int getX() {
        return board[0].length - 1;
    }

    int getY() {
        return board.length - 1;
    }

}
