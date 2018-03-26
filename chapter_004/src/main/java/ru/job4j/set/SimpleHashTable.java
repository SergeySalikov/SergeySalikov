package ru.job4j.set;


public class SimpleHashTable<T> {
    private Object[] arrayObjects;
    private int sizeHashTable;
    private int counter;

    public SimpleHashTable() {
        sizeHashTable = 5;
        arrayObjects = new Object[5];
    }


    public boolean add(T value) {
        if ((double) counter / (double) sizeHashTable >= 0.8) {
            reSize(sizeHashTable);
        }
        if (!contains(value)) {
            int position = getHash(value);
            arrayObjects[position] = value;
            counter++;
            return true;
        }
        return false;
    }

    public boolean contains(T value) {
        int position = getHash(value);
        return arrayObjects[position] != null;
    }

    public boolean remove(T value) {
        int position = getHash(value);
        if (arrayObjects[position] != null) {
            arrayObjects[position] = null;
            counter--;
            return true;
        }
        return false;
    }

    private int getHash(T value) {
        return value.hashCode() % sizeHashTable;
    }

    private boolean isPrime(int n) {
        for (int i = 2; (i * i <= n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int getPrime(int min) {
        for (int i = min + 1; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    private void reSize(int oldSize) {
        sizeHashTable = getPrime(oldSize * 2);
        Object[] temp = new Object[sizeHashTable];
        for (Object obj : arrayObjects) {
            if (obj != null) {
                temp[getHash((T) obj)] = obj;
            }
        }
        arrayObjects = temp;
    }


}

