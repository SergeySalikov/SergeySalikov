package ru.job4j.chess.templates;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.ImpossibleMoveException;

public class Bishop extends Figure {

    public Bishop(int x, int y) {
        super(x, y);
    }

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int numberCell = Math.abs(source.getY() - dest.getY());
        Cell[] cell = new Cell[numberCell];
        if (dest.getX() <= 0 || dest.getY() <= 0 || dest.getX() == source.getX() || dest.getY() == source.getY() || dest.getX() > 8 || dest.getY() > 8)
            throw new ImpossibleMoveException("(1)не возможен ход в клетку:", dest);
        for (int i = 1; i <= numberCell; i++) {
            if (source.getX() < dest.getX() && source.getY() < dest.getY()) {
                cell[i - 1] = new Cell(source.getX() + i, source.getY() + i); //юго-восток
            } else if (source.getX() > dest.getX() && source.getY() > dest.getY()) {
                cell[i - 1] = new Cell(source.getX() - i, source.getY() - i); //северо-запад
            } else if (source.getX() < dest.getX() && source.getY() > dest.getY()) {
                cell[i - 1] = new Cell(source.getX() + i, source.getY() - i); //северо-восток
            } else if (source.getX() > dest.getX() && source.getY() < dest.getY()) {
                cell[i - 1] = new Cell(source.getX() - i, source.getY() + i); //юго-запад
            }
        }
        if (cell[numberCell - 1].getX() != dest.getX() || cell[numberCell - 1].getY() != dest.getY())
            throw new ImpossibleMoveException("(2)не возможен ход в клетку:", dest);

        return cell;
    }
}
