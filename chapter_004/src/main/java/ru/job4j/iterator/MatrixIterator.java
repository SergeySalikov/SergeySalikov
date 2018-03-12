package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {
    private final int[][] array;
    int row = 0;
    int columns = 0;

    MatrixIterator(final int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return row < array.length;
    }

    @Override
    public Object next() {
        if (row == array.length) {
            throw new NoSuchElementException();
        }
        int result = array[row][columns];
        if (columns == array[row].length - 1) {
            columns = 0;
            row++;
        } else {
            columns++;
        }
        return result;
    }
}
