package ru.job4j.generic;

import java.util.Iterator;

abstract class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> simpleArray;
    private final int size;

    AbstractStore(int size) {
        simpleArray = new SimpleArray<T>(size);
        this.size = size;

    }

    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return getIndex(id) == -1 ? false : simpleArray.set(getIndex(id), model);
    }

    @Override
    public boolean delete(String id) {
        return simpleArray.delete(getIndex(id));
    }

    @Override
    public T findById(String id) {
        return simpleArray.get(getIndex(id));
    }

    private int getIndex(String id) {
        int searchIndex = 0;
        Iterator<T> it = simpleArray.iterator();
        while (it.hasNext()) {
            T temp = it.next();
            if (temp.getId().equals(id)) {
                break;
            }
            searchIndex++;
        }
        return searchIndex == size ? -1 : searchIndex;
    }
}
