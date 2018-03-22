package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListNode<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
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

            @Override
            public boolean hasNext() {
                if (counter != modCount) {
                    throw new ConcurrentModificationException();
                }
                return data != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T result = data.getValue();
                data = data.next;
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

    public void addStack(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = first;
        first = newNode;
    }

    public T deleteLast() {
        T result = first.getValue();
        first = first.next;
        return result;
    }

    public T deleteFirst() {
        T result = first.next.getValue();
        first.next = first.next.next;
        return result;
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
