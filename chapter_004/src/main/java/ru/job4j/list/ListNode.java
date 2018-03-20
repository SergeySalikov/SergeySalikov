package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListNode<T> implements Iterable<T> {

    private Node<T> first;
    public Node<T> last;
    private int modCount = 0;

    public ListNode() {
        this.first = new Node<T>();
        this.last = new Node<T>();
    }

    @Override
    public Iterator iterator() {
        return new Iterator<T>() {
            Node<T> data = first.next;
            final private int counter = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (counter != modCount) {
                    throw new ConcurrentModificationException();
                }
                return !isEmpty() && index < modCount;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (counter != modCount) {
                    throw new ConcurrentModificationException();
                }
                T result = data.getValue();
                data = data.next;
                index++;
                return result;
            }
        };
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            first.next = newNode;
            last = newNode;
            last.next = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        modCount++;
    }

    private boolean isEmpty() {
        return first.next == null;
    }

    public T get(int index) {
        Node temp = first.next;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        return (T) temp.getValue();
    }
}
