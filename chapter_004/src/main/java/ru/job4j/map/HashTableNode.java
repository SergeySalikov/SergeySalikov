package ru.job4j.map;

import java.util.Objects;

class HashTableNode<K, V> {
    private K key;
    private V value;

    HashTableNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return this.key;
    }

    V getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HashTableNode<?, ?> that = (HashTableNode<?, ?>) o;
        return Objects.equals(key, that.key)
                && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "{"
                + "key="
                + key
                + ", value="
                + value
                + '}';
    }
}
