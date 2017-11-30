package ru.job4j.chess.exceptions;

import ru.job4j.chess.Cell;

public class ImpossibleMoveException extends RuntimeException {
    private int x;
    private int y;

    public ImpossibleMoveException(String msg, Cell cell) {
        super(msg);
        this.x = cell.getX();
        this.y = cell.getY();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}
