package ru.job4j.start;
/**
 * interface Input.
 *
 * @author Salikov.
 * @version 1.
 */

public interface Input {
    String ask(String question);

    int ask(String question, int[] range);
}
