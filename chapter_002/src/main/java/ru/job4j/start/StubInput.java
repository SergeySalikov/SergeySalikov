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

    StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[position++];
    }

    public int ask(String question, int[] range) {
        return Integer.parseInt(answers[position++]);
    }
}
