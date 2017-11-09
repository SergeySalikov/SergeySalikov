package ru.job4j.start;

/**
 * Класс StubInput.
 *
 * @author Salikov.
 * @version 1.
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[position++];
    }
}
