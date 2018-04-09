package ru.job4j.tree;

class NodeBST<E extends Comparable<E>> {
    NodeBST<E> leftChild;
    NodeBST<E> rightChild;
    private E value;

    NodeBST(E value) {
        this.value = value;
    }

    public E getValue() {
        return this.value;
    }
}
