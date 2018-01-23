package ru.job4j;

import java.util.HashMap;
import java.util.List;

/**
 * class UserConvert.
 *
 * @author Salikov.
 * @version 1.
 */

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.id, user);
        }
        return result;
    }
}
