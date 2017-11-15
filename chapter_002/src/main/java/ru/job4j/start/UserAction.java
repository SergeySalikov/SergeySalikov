package ru.job4j.start;

/**
 * interface UserActions.
 *
 * @author Salikov.
 * @version 1.
 */
public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
