package ru.job4j.list;

public class StackList<T> {
    private ListNode<T> listNode;

    public StackList() {
        listNode = new ListNode<>();
    }

    public T poll() {
        return listNode.deleteLast();
    }

    public void push(T value) {
        listNode.addStack(value);
    }
}
