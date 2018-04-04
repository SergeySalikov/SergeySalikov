package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E>, Iterable<E> {
    private Node<E> root;
    private int modCount = 0;

    public Tree(final E value) {
        root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        Node<E> newNode = new Node<>(child);
        if (root == null) {
            root = newNode;
        } else {
            Optional<Node<E>> optional = findBy(parent);
            if (!optional.isPresent()) {
                return false;
            }
            Node<E> parentNode = optional.get();
            for (Node<E> node : parentNode.leaves()) {
                if (node.eqValue(child)) {
                    return false;
                }
            }
            parentNode.leaves().add(newNode);
        }
        modCount++;
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int modCounterIterator = modCount;
            Queue<E> dataIterator = new LinkedList<>();
            boolean newIterator = true;

            @Override
            public boolean hasNext() {
                if (newIterator) {
                    fillData(root);
                    newIterator = false;
                }
                if (modCounterIterator != modCount) {
                    throw new ConcurrentModificationException();
                }

                return !dataIterator.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return dataIterator.poll();
            }

            private void fillData(Node<E> currentNode) {
                if (currentNode.leaves() != null) {
                    for (Node<E> node : currentNode.leaves()) {
                        fillData(node);
                    }
                }
                dataIterator.offer(currentNode.getValue());
            }
        };
    }

    private boolean isBinaryCheck(Node<E> currentNode, boolean flag) {
        boolean result = flag;
        if (currentNode.leaves().size() > 2) {
            result = false;
            return result;
        }
        if (currentNode.leaves() != null) {
            for (Node<E> node : currentNode.leaves()) {
                result = isBinaryCheck(node, result);
            }
        }
        return result;
    }

    public boolean isBinary() {
        return isBinaryCheck(root, true);
    }

}
