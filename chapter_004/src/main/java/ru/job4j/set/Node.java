package ru.job4j.set;

class Node<T> {
    private T value;
    Node<T> next;
    Node(T value) {
        this.value = value;
        next = null;
    }

    T getValue() {
        return value;
    }
}
