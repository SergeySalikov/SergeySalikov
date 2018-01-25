package ru.job4j.comparable;

/**
 * class User.
 *
 * @author Salikov.
 * @version 1.
 */
public class User implements Comparable<User> {
    String name;
    int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(User user) {
        int result = Integer.compare(this.age, user.age);
        if (result == 0) {
            result = this.name.compareTo(user.name);
        }
        return result;
    }
}
