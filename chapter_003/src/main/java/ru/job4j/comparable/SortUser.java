package ru.job4j.comparable;

import java.util.*;

/**
 * class SortUser.
 *
 * @author Salikov.
 * @version 1.
 */
public class SortUser {

    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>();
        result.addAll(list);
        return result;
    }

    public List<User> sortNameLength(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.name.length() - o2.name.length();
                    }
                }
        );
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int result = o1.name.compareTo(o2.name);
                        if (result == 0) {
                            result = o1.age - o2.age;
                        }
                        return result;
                    }
                }
        );
        return users;
    }
}
