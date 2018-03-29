package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> {
    private HashTableNode<K, V>[] hashTableNodes;
    private int sizeHashTable;
    private int counter = 0;
    private int modCount = 0;

    public SimpleMap() {
        this.sizeHashTable = 5;
        this.hashTableNodes = new HashTableNode[sizeHashTable];
    }

    public boolean insert(K key, V value) {
        if ((double) counter / (double) sizeHashTable >= 0.8) {
            reSize(sizeHashTable);
        }
        if (!isDouble(key)) {
            int position = getHash(key);
            hashTableNodes[position] = new HashTableNode<>(key, value);
            counter++;
            modCount++;
            return true;
        }
        return false;
    }

    public V get(K key) {
        int position = getHash(key);
        if (hashTableNodes[position] == null) {
            throw new NullPointerException();
        }
        return hashTableNodes[position].getValue();
    }

    public boolean delete(K key) {
        int position = getHash(key);
        if (hashTableNodes[position] != null) {
            hashTableNodes[position] = null;
            counter--;
            modCount++;
            return true;
        }
        return false;
    }


    private int getHash(K key) {
        return Math.abs(key.hashCode() % sizeHashTable);
    }

    private boolean isDouble(K key) {
        return hashTableNodes[getHash(key)] != null;
    }

    private boolean isPrime(int n) {
        for (int i = 2; (i * i <= n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void reSize(int oldSize) {
        sizeHashTable = getPrime(oldSize * 2);
        HashTableNode<K, V>[] tempArray = new HashTableNode[sizeHashTable];
        for (HashTableNode<K, V> tempNode : hashTableNodes) {
            if (tempNode != null) {
                tempArray[getHash(tempNode.getKey())] = tempNode;
            }
        }
        hashTableNodes = tempArray;
    }

    private int getPrime(int min) {
        for (int i = min + 1; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    public Iterator iterator() {
        return new Iterator<HashTableNode>() {
            int currentIndex = 0;
            int changeCount = modCount;

            @Override
            public boolean hasNext() {
                if (changeCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return currentIndex < sizeHashTable;
            }

            @Override
            public HashTableNode<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int tempIndex = currentIndex;
                searchIndex();
                if (tempIndex == currentIndex) {
                    return hashTableNodes[currentIndex++];
                } else {
                    return hashTableNodes[tempIndex];
                }
            }

            private void searchIndex() {
                for (int i = currentIndex + 1; i < sizeHashTable; i++) {
                    if (hashTableNodes[i] != null) {
                        currentIndex = i;
                        break;
                    }
                }
            }

        };

    }
}

