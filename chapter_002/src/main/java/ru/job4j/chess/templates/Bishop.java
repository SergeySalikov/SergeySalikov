package ru.job4j.chess.templates;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.ImpossibleMoveException;

public class Bishop extends Figure {

    public Bishop(int x, int y) {
        super(x, y);
    }

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int deltaX = source.getX() - dest.getX();
        int deltaY = source.getY() - dest.getY();
        int size = Math.abs(deltaY);
        Cell[] cell = new Cell[size];
        if (dest.getX() <= 0 || dest.getY() <= 0 || dest.getX() == source.getX() || dest.getY() == source.getY() || dest.getX() > 8 || dest.getY() > 8)
            throw new ImpossibleMoveException("(1)не возможен ход в клетку:", dest);
        for (int i = 0; i < size; i++) {
            cell[i] = new Cell(source.getX() + (deltaX < 0 ? 1 : -1) * (i + 1), source.getY() + (deltaY < 0 ? 1 : -1) * (i + 1));
        }
        if (cell[size - 1].getX() != dest.getX() || cell[size - 1].getY() != dest.getY())
            throw new ImpossibleMoveException("(2)не возможен ход в клетку:", dest);
        return cell;
    }
}
