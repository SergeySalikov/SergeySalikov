package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ListNode<T> implements Iterable<T> {
    @GuardedBy("this")
    private volatile Node<T> first;
    private volatile Node<T> last;
    private volatile int modCount = 0;

    public ListNode() {
        this.first = new Node<>();
        this.last = new Node<>();
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

    public synchronized void add(T value) {
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

    public synchronized void addStack(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = first;
        first = newNode;
    }

    public synchronized T deleteLast() {
        T result = first.getValue();
        first = first.next;
        return result;
    }

    public synchronized T deleteFirst() {
        T result = first.next.getValue();
        first.next = first.next.next;
        return result;
    }

    private boolean isEmpty() {
        return first.next == null;
    }

    public synchronized T get(int index) {
        Node temp = first.next;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        return (T) temp.getValue();
    }
}
