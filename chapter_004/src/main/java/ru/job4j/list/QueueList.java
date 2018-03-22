package ru.job4j.list;

public class QueueList<T> {
    private ListNode<T> listQueue;

    public QueueList() {
        listQueue = new ListNode<>();
    }

    public void push(T value) {
        listQueue.add(value);
    }

    public T poll() {
        return listQueue.deleteFirst();
    }
}
