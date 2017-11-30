package ru.job4j.chess.templates;

import ru.job4j.chess.Cell;

public abstract class Figure {
    final Cell position;

    public Figure(int x, int y) {
        position = new Cell(x, y);
    }

    public abstract Cell[] way(Cell source, Cell dest);
}
