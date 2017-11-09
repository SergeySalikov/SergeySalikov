package ru.job4j.start;

import java.util.Scanner;


/**
 * class ConsoleInput.
 *
 * @version 1.
 * @autor Salikov.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
