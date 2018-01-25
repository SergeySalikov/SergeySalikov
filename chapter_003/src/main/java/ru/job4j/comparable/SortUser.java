package ru.job4j.comparable;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
}
