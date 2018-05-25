package ru.job4j.synchr;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private List<User> storage;

    public UserStorage() {
        storage = new ArrayList<>();
    }

    public synchronized boolean add(User user) {
        return storage.add(user);
    }

    public synchronized boolean update(User user) {
        int index = searchById(user.getId());
        if (index != -1) {
            storage.remove(index);
            storage.add(user);
        }
        return index != -1;
    }

    public synchronized boolean delete(User user) {
        return storage.remove(user);
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        User fromUser = storage.get(searchById(fromId));
        User toUser = storage.get(searchById(toId));
        fromUser.setAmount(fromUser.getAmount() - amount);
        toUser.setAmount(toUser.getAmount() + amount);
    }

    private synchronized int searchById(int userId) {
        int index = -1;
        for (User userSearch : storage) {
            if (userSearch.getId() == userId) {
                index = storage.indexOf(userSearch);
                break;
            }
        }
        return index;
    }
}
