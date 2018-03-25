package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSetNode<E> implements Iterable<E> {
    Node<E> first;

    @Override
    public Iterator iterator() {
        return new Iterator<E>() {
            Node<E> itNode = first;

            @Override
            public boolean hasNext() {
                return itNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = itNode.getValue();
                itNode = itNode.next;
                return result;
            }
        };
    }

    public boolean add(E value) {
        boolean result = false;
        if (!isDouble(value)) {
            Node<E> newNode = new Node<>(value);
            if (first == null) {
                first = newNode;
            } else {
                newNode.next = first;
                first = newNode;
            }
            result = true;
        }
        return result;
    }

    private boolean isDouble(E value) {
        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            E temp = it.next();
            if (value.equals(temp)) {
                return true;
            }
        }
        return false;
    }
}

