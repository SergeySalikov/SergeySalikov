package ru.job4j.bomberMan;


import java.util.Random;

public class Hero extends Thread {
    private final Board playBoard;
    private Cell position;
    private Random random = new Random();

    Hero(Board board, int x, int y) {
        playBoard = board;
        position = board.getCell(x, y);
        this.start();
    }

    public void run() {
        Cell newPosition;
        try {
            position.cellLock();
            while (!isInterrupted()) {
                newPosition = getNewPosition();
                boolean isMove = playBoard.move(position, newPosition);
                if (isMove) {
                    position = newPosition;
                    sleep(1000);
                }
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private Cell getNewPosition() {
        int x;
        int y;
        Cell result = position;
        boolean isNewCell = false;
        while (!isNewCell) {
            x = position.getX() + random.nextInt(2) * (random.nextBoolean() ? 1 : -1);
            y = position.getY() + random.nextInt(2) * (random.nextBoolean() ? 1 : -1);
            if (x >= 0 && y >= 0 && x <= playBoard.getX() && y <= playBoard.getY() && !result.equals(playBoard.getCell(x, y))) {
                result = playBoard.getCell(x, y);
                isNewCell = true;
            }
        }
        return result;
    }

    public void shutdown() {
        this.interrupt();
    }
}
