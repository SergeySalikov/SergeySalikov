package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator {
    private final int[] array;
    int index = 0;

    PrimeIterator(final int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return searchPrime(array, index) != -1;
    }

    @Override
    public Object next() {
         index = this.searchPrime(array, index);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }

    private int searchPrime(int[] array, int index) {
        int result = -1;
        for (int out = index; out < array.length; out++) {
            if (this.isPrime(array[out])) {
                result = out;
                break;
            }
        }
        return result;
    }

    public boolean isPrime(int value) {
        boolean result = true;
        if (value == 1) {
            result = false;
        }
        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}