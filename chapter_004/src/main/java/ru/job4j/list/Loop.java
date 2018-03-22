package ru.job4j.list;

public class Loop<T> {
    Node<T> slow;
    Node<T> fast;

    boolean hasLoop(Node<T> first) {
        Node<T> root = new Node<>();
        root.next = first;
        slow = root;
        fast = root;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}