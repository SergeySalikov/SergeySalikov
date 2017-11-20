package ru.job4j.start;
/**
 * class ValidateInput.
 *
 * @author Salikov.
 * @version 1.
 */

public class ValidateInput extends ConsoleInput {

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("please enter validate data again.");
            }
        }
        while (invalid);
        return value;

    }
}
