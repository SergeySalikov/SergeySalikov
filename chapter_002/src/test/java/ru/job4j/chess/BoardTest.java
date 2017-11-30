package ru.job4j.chess;

import ru.job4j.chess.exceptions.*;
import org.junit.Test;
import ru.job4j.chess.templates.Bishop;
import ru.job4j.chess.templates.Figure;

/**
 * Test
 *
 * @author Salikov.
 * @version 1.
 */

public class BoardTest {
    @Test(expected = OccupiedWayException.class)
    public void whenTheCellIsBusyThenError() throws OccupiedWayException {
        Board board = new Board();
        Figure bishopMove = new Bishop(5, 5);
        Figure bishopStand = new Bishop(3, 3);
        Cell source = new Cell(5, 5);
        Cell dest = new Cell(2, 2);
        board.figures[5][5] = bishopMove;
        board.figures[3][3] = bishopStand;
        board.move(source, dest);
    }
}
