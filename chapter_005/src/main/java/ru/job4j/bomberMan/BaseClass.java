package ru.job4j.bomberMan;

abstract class BaseClass {
    Board board;
    Cell cell;

    BaseClass(Board board, int x, int y) {
        this.cell = board.getCell(x, y);
        this.board = board;
    }

    boolean move(Cell source, Cell dist) throws InterruptedException {
        boolean result = false;
        if (board.checkBound(dist)) {
            result = dist.cellLock();
        }
        if (result) {
            source.CellUnlock();
            cell = dist;
        }
        return result;
    }
}
