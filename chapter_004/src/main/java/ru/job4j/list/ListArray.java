package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ListArray<E> implements Iterable<E> {
    @GuardedBy("this")
    private volatile Object[] container;
    private int index = 0;
    private volatile int modCount = 0;

    public ListArray() {
        container = new Object[3];
    }

    public synchronized void add(E value) {
        if (index == container.length - 1) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[index++] = value;
        modCount++;
    }

    public synchronized E get(int position) {
        return (E) container[position];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int counter = 0;
            private final int modCountIt = modCount;

            @Override
            public boolean hasNext() {
                if (modCountIt != modCount) {
                    throw new ConcurrentModificationException();
                }
                return counter < index;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[counter++];
            }
        };
    }
}
