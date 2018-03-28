package ru.job4j.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserTest {
    @Test
    public void when() {
        Map<User, Object> map = new HashMap<>();
        User userFirst = new User("Bob", 5, 1950, 1, 1);
        User userSecond = new User("Bob", 5, 1950, 1, 1);
        map.put(userFirst, new Object());
        map.put(userSecond, new Object());
        for (User user : map.keySet()) {
            System.out.println(user);
        }
    }
}
