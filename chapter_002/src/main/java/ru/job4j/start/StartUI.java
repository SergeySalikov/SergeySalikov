package ru.job4j.start;


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
            menu.select(input.ask("select: ", menu.getRange()));
        }
        while (!"y".equals(this.input.ask("EXIT?(y): ")));


    }


    /**
     * Метод main - точка входа в программу.
     *
     * @param args
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        StartUI start = new StartUI(input);
        start.init();


    }


}