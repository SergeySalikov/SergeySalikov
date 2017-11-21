package ru.job4j.start;

/**
 * abstract class BaseAction.
 *
 * @author Salikov.
 * @version 1.
 */
abstract class BaseAction implements UserAction {
    String name;
    int key;

    BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }

}
