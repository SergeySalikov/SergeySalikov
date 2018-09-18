package ru.job4j.bomberMan;

public class Wall extends Thread {
    private Cell cell;
    private Board board;

    Wall(Board board, int x, int y) {
        this.board = board;
        this.cell = board.getCell(x, y);
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                cell.cellLock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
