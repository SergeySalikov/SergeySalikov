package ru.job4j.set;

import java.util.Iterator;
import ru.job4j.list.ListArray;

public class SimpleSet<E> implements Iterable<E> {
    ListArray<E> setArray;

    public SimpleSet() {
        setArray = new ListArray<>();
    }

    @Override
    public Iterator<E> iterator() {
        return setArray.iterator();
    }

    public boolean add(E value) {
        for (E e : setArray) {
            if (e.equals(value)) {
                return false;
            }
        }
        setArray.add(value);
        return true;
    }
}
