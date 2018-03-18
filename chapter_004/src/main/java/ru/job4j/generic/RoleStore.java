package ru.job4j.generic;

public class RoleStore extends AbstractStore<Role> {
    SimpleArray<Role> roleArray;

    RoleStore(int size) {
        super(size);
    }
}