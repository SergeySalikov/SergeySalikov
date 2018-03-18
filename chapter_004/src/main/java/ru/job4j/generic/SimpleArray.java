package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;

    SimpleArray(int size) {
        this.objects = new Object[size];
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int indexItr = 0;

            @Override
            public boolean hasNext() {
                return indexItr < index;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return objects[indexItr++];
            }
        };
    }

    public boolean add(T value) {
        if (index >= objects.length) {
            return false;
        }
        this.objects[index++] = value;
        return true;
    }

    public T get(int position) {
        return (T) this.objects[position];
    }

    public boolean delete(int position) {
        if (position >= index) {
            return false;
        }
        for (int i = position; i < index - 1; i++) {
            objects[i] = objects[i + 1];
        }
        index--;
        return true;
    }

    public boolean set(int position, T model) {
        if (position >= index) {
            return false;
        }
        objects[position] = model;
        return true;
    }
}

