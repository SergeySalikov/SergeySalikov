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
        boolean result = false;
        if (this.searchPrime(array, index) != -1) {
            result = true;
        }
        return result;
    }

    @Override
    public Object next() {
        int indexPrime = this.searchPrime(array, index);
        index = indexPrime + 1;
        if (indexPrime == -1) {
            throw new NoSuchElementException();
        }
        return array[indexPrime];
    }

    private int searchPrime(int[] array, int index) {
        int result = -1;
        for (int out = index; out < array.length; out++) {
            if (this.prime(array[out])) {
                result = out;
                break;
            }
        }
        return result;
    }

    public boolean prime(int value) {
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