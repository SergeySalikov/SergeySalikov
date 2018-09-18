package ru.job4j.bomberMan;

import java.util.Random;

class Board {
    private final Cell[][] board;
    private int sizeX;
    private int sizeY;
   public Board(int x, int y) {
       sizeX = x;
       sizeY = y;
        board = new Cell[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                board[i][j] = new Cell(j, i);
            }
        }
    }

  public boolean checkBound(Cell dist) {
        int x = dist.getX();
        int y = dist.getY();
        boolean result = false;
        if (x > 0 && y > 0 && x < sizeX && y <sizeY) {
            result = true;
        }
        return result;
    }
    public boolean checkBound(int x, int y) {
        boolean result = false;
        if (x > 0 && y > 0 && x < sizeX && y < sizeY) {
            result = true;
        }
        return result;
    }
    public Cell getCell(int x, int y) {
       return board[y][x];
    }
}
