package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.templates.*;

public class Board {
    Figure[][] figures = new Figure[8][8];

    Board() {
        this.figures = new Figure[8][8];
    }

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, FigureNotFoundException {
        boolean result = true;
        if (figures[source.getX()][source.getY()] == null) throw new FigureNotFoundException("Клетка пуста", source);

        for (Cell cell : figures[source.getX()][source.getY()].way(source, dest)) {
            if (figures[cell.getX()][cell.getY()] != null) throw new OccupiedWayException("На пути преграда", cell);
        }
        return result;
    }
}
