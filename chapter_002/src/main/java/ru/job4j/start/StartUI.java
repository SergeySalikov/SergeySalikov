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
    private static Tracker tracker = new Tracker();
    private static final String ADD = "0";
    private static final String SHOWALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";

    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Метод main - точка входа в программу.
     *
     * @param args
     */
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        StartUI start = new StartUI(input);

        while (true) {
            String select = input.menuSelect();
            if (EXIT.equals(select)) {
                break;
            } else if (ADD.equals(select)) {
                Item item = input.itemCreate();
                tracker.add(item);
                System.out.println("add");
            } else if (SHOWALL.equals(select)) {
                for (Item item : tracker.findAll()) {
                    System.out.println(item.getName() + " " + item.getDesc() + " " + item.getId());
                }
            } else if (EDIT.equals(select)) {
                Item item = input.itemUpdate();
                tracker.update(item);
            } else if (DELETE.equals(select)) {
                String idDelete = input.itemID();
                tracker.delete(idDelete);
            } else if (FINDBYID.equals(select)) {
                String id = input.itemID();
                System.out.println(tracker.findById(id).getName() + " " + tracker.findById(id).getDesc());
            } else if (FINDBYNAME.equals(select)) {
                String name = input.itemName();
                for (Item item : tracker.findByName(name)) {
                    System.out.println("desc: " + item.getDesc() + " id " + item.getId());
                }
            }
        }
    }
}