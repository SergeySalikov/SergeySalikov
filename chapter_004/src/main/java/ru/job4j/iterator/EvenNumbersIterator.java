package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private final int[] array;
    int index = 0;

    EvenNumbersIterator(final int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        int indexEven = this.searchEvenNumber(array, index);
        if (indexEven != -1) {
            result = true;
        }
        return result;
    }

    @Override
    public Object next()  {
        int indexEven = this.searchEvenNumber(array, index);
        index = indexEven + 1;
        if (indexEven == -1) {
            throw new NoSuchElementException();
        }
        return array[indexEven];
    }

    private int searchEvenNumber(int[] arr, int index) {
        int result = -1;
        for (int i = index; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

}
