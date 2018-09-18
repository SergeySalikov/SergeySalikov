package ru.job4j.bomberMan;

public class Hero extends BaseClass {

    public Hero(Board board, int x, int y) {
        super(board, x, y);
    }

    public Cell up() {
        return board.getCell(cell.getX(), cell.getY() + 1);
    }

    public Cell down() {
        return board.getCell(cell.getX(), cell.getY() - 1);
    }

    public Cell left() {
        return board.getCell(cell.getX() - 1, cell.getY());
    }

    public Cell right() {
        return board.getCell(cell.getX() + 1, cell.getY());
    }

    public void start(Thread moveThread) {
        Thread bomberThread = new Thread() {
            @Override
            public void run() {
                try {
                    cell.cellLock();
                    while (true) {
                        Cell dist;
                        String direction = "up";
                        switch (direction) {
                            case "up":
                                dist = up();
                                break;
                            case "down":
                                dist = down();
                                break;
                            case "left":
                                dist = left();
                                break;
                            case "right":
                                dist = right();
                                break;
                            default:
                                dist = cell;
                        }
                        if (move(cell, dist)) {
                            sleep(1000);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        bomberThread.start();
    }
}