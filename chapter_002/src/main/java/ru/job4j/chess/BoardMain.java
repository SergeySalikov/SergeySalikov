package ru.job4j.chess;

import ru.job4j.chess.templates.Bishop;

public class BoardMain {


    public static void main(String[] args) {
        Board board = new Board();
        Bishop bishop1 = new Bishop(3, 2);
        Bishop bishop2 = new Bishop(4, 3);
        board.figures[3][2] = bishop1;
        board.figures[5][4] = bishop2;
        Cell source = new Cell(3, 2);
        Cell dest = new Cell(5, 4);
        Cell[] cellArray = bishop1.way(source, dest);
        for (Cell cell : cellArray) {
            System.out.println(cell.getX() + " " + cell.getY());
        }
        System.out.println(board.move(source, dest));
    }
}
