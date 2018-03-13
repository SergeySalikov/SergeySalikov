package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorOfIterators {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> ioi) {
        return new Iterator<Integer>() {
            Iterator<Integer> it;

            @Override
            public boolean hasNext() {
                boolean result = true;
                while (it == null || !it.hasNext()) {
                    if (!ioi.hasNext()) {
                        return false;
                    }
                    it = ioi.next();
                }
                return result;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return it.next();
            }
        };
    }
}
