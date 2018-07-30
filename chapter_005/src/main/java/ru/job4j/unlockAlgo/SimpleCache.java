package ru.job4j.unlockAlgo;

import java.util.concurrent.ConcurrentHashMap;

public class SimpleCache {
    private final ConcurrentHashMap<Integer, Base> cache;


    public SimpleCache() {
        cache = new ConcurrentHashMap<>();
    }


    public void add(Base model) {
        cache.put(model.getId(), model);
    }

    public void update(Base model) throws OptimisticException {
        Base checkError = cache.computeIfPresent(model.getId(), (id, currentBase) -> {
            Base result;
            if (model.getVersion() == currentBase.getVersion()) {
                model.updateVersion();
                result = model;
            } else {
                result = currentBase;
            }
            return result;
        });
        if (checkError != model) {
            throw new OptimisticException("old version");
        }
    }

    public void delete(Base model) {
        cache.remove(model.getId());
    }
}
