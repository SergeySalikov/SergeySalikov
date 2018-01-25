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

    private List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /**
     * @param item - заявка.
     * @return - добавленную заявку.
     */
    public Item add(Item item) {
        item.setId(this.generatedId());
        items.add(item);
        return item;
    }

    /**
     * @param itemUpdate - заявка заменяющая другую по id.
     */
    public void update(Item itemUpdate) {
        for (Item item : items) {
            if (itemUpdate.getId().equals(item.getId())) {
                Collections.replaceAll(items, item, itemUpdate);
                break;
            }
        }
    }

    /**
     * @param id - id удаляемой заявки.
     */
    public void delete(String id) {
        for (Item item : items) {
            if (id.equals(item.getId())) {
                items.remove(item);
                break;
            }
        }
    }

    /**
     * @return - возвращает копию массива this.items без null элементов.
     */
    public Item[] findAll() {
        Item[] result = new Item[items.size()];
        items.toArray(result);
        return result;
    }


    /**
     * @param key - строка для поиска в поле Item.name.
     * @return - массив Item с совпадением поля Item.name и key.
     */
    public Item[] findByName(String key) {
        List<Item> temp = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                temp.add(item);
            }
        }
        Item[] result = new Item[temp.size()];
        temp.toArray(result);
        return result;
    }

    /**
     * @param id - id искомого Item,а.
     * @return null если объект не найден или найденый объект с совпадающем id.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (id.equals(item.getId())) {
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
        int index = items.indexOf(item);
        return index;
    }
}