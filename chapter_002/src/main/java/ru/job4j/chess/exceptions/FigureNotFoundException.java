package ru.job4j.chess.exceptions;

import ru.job4j.chess.Cell;

public class FigureNotFoundException extends RuntimeException {
    private int x;
    private int y;

    public FigureNotFoundException(String msg, Cell cell) {
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
