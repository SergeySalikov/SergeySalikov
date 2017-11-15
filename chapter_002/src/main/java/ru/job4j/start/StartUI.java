package ru.job4j.start;

import ru.job4j.models.*;

/**
 * class StartUI.
 *
 * @author Salikov.
 * @version 1.
 */
class StartUI {

    private Input input;
    static Tracker tracker;


    public StartUI(Input input) {
        this.input = input;
        this.tracker = new Tracker();
    }

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("select: "));
            menu.select(key);
        }
        while (!"y".equals(this.input.ask("EXIT?(y): ")));


    }


    /**
     * Метод main - точка входа в программу.
     *
     * @param args
     */
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        StartUI start = new StartUI(input);
        start.init();


    }


}