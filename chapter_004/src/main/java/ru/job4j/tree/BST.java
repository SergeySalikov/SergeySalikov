package ru.job4j.tree;

import java.util.*;

public class BST<E extends Comparable<E>> implements Iterable<E> {
    private NodeBST<E> root;
    private int modCount = 0;

    public BST(E value) {
        root = new NodeBST<>(value);
    }


    public void add(E value) {
        NodeBST<E> newNode = new NodeBST<>(value);
        NodeBST<E> currentNode = root;
        NodeBST<E> parent;
        while (true) {
            parent = currentNode;
            if (value.compareTo(currentNode.getValue()) < 0) {
                currentNode = parent.leftChild;
                if (currentNode == null) {
                    parent.leftChild = newNode;
                    modCount++;
                    return;
                }
            } else {
                currentNode = parent.rightChild;
                if (currentNode == null) {
                    parent.rightChild = newNode;
                    modCount++;
                    return;
                }
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Queue<E> listNodeValue = new LinkedList<>();
            boolean isNewIterator = true;
            int modCounterIterator = modCount;

            @Override
            public boolean hasNext() {
                if (isNewIterator) {
                    addValueFromQueue(root);
                    isNewIterator = false;
                }
                if (modCounterIterator != modCount) {
                    throw new ConcurrentModificationException();
                }
                return !listNodeValue.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return listNodeValue.poll();
            }

            private void addValueFromQueue(NodeBST<E> currentNode) {
                if (currentNode != null) {
                    addValueFromQueue(currentNode.leftChild);
                    listNodeValue.offer(currentNode.getValue());
                    addValueFromQueue(currentNode.rightChild);
                }
            }
        };
    }
}
