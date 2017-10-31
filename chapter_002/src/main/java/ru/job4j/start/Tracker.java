package ru.job4j.start;

import ru.job4j.models.*;

import java.util.*;

/**
 * class Tracker.
 *
 * @author Salikov.
 * @version 1.
 */
public class Tracker {

    private Item[] items = new Item[100];
    int nElems = 0;
    private static final Random RN = new Random();

    /**
     * @param item - заявка.
     * @return - добавленную заявку.
     */
    public Item add(Item item) {
        item.setId(this.generatedId());
        items[nElems++] = item;
        return item;
    }

    /**
     * @param itemUpdate - заявка заменяющая другую по id.
     */
    public void update(Item itemUpdate) {
        for (int i = 0; i <= nElems; i++) {
            if (items[i].getId().equals(itemUpdate.getId())) {
                items[i] = itemUpdate;
                break;
            }
        }
    }

    /**
     * @param itemDelete - удаляемая заявка.
     */
    public void delete(Item itemDelete) {
        int bound = nElems;
        for (int out = 0; out <= bound; out++) {
            if (itemDelete.getId().equals(items[out].getId())) {
                items[out] = null;
                for (int in = out; in < bound; in++) {
                    items[in] = items[in + 1];
                }
                nElems--;
                break;
            }
        }
    }

    /**
     * @return - возвращает копию массива this.items без null элементов.
     */
    public Item[] findAll() {
        Item[] result = Arrays.copyOf(items, nElems + 1);
        return result;
    }

    /**
     * @param key - строка для поиска в поле Item.name.
     * @return - массив Item с совпадением поля Item.name и key.
     */
    public Item[] findByName(String key) {
        int count = 0;
        Item[] result = new Item[nElems];
        int bound = nElems;
        for (int out = 0; out < bound; out++) {
            if (items[out].getName().equals(key)) {
                result[count++] = items[out];
            }
        }
        result = Arrays.copyOf(result, count);
        return result;
    }

    /**
     * @param id - id искомого Item,а.
     * @return null если объект не найден или найденый объект с совпадающем id.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * @return - сгенерированное целочисленное число.
     */
    String generatedId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * @param item - объект Item.
     * @return возвращает индекс в массиве items или -1 если нет такого объекта в данном масиве.
     */
    public int findIndex(Item item) {
        int index = -1;
        for (int i = 0; i <= nElems; i++) {
            if (items[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }
}