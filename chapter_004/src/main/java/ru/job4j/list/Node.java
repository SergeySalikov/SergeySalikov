package ru.job4j.list;

 class Node<T> {
    private T value;
    Node<T> next;
     Node(T value) {
        this.value = value;
        next = null;
    }
    Node() {
         this.value = null;
         this.next = null;
    }
    T getValue() {
        return value;
    }
}
