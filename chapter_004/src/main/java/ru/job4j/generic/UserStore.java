package ru.job4j.generic;

public class UserStore extends AbstractStore<User> {
    UserStore(int size) {
        super(size);
    }
}