package ru.job4j.bomberMan;

import java.util.Random;

public class Monster extends BaseClass {

    public Monster(Board board, int x, int y) {
        super(board, x, y);
    }

    public Cell newPosition() {
        Random random = new Random();
        int x;
        int y;
        Cell result = this.cell;
        boolean isNewCell = false;
        while (!isNewCell) {
            x = this.cell.getX() + random.nextInt(2) * (random.nextBoolean() ? 1 : -1);
            y = this.cell.getY() + random.nextInt(2) * (random.nextBoolean() ? 1 : -1);
            if (board.checkBound(x, y) && (x != this.cell.getX() || y != this.cell.getY())) {
                result = board.getCell(x, y);
                isNewCell = true;
            }
        }
        return result;
    }

    public void start() {
        Thread heroThread = new Thread() {
            @Override
            public void run() {
                try {
                    cell.cellLock();
                    while (true) {
                        Cell dist = newPosition();
                        if (move(cell, dist)) {
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


}
