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
    private static final String ADD = "0";
    private static final String SHOWALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";
    private String startMenu = ("0.Add new item\n1.Show all items\n2.Edit item\n3.Delete item\n"
            + "4.Find item by id\n5.Find items by name\n6.Exit program\n");

    public StartUI(Input input) {
        this.input = input;
        this.tracker = new Tracker();
    }

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        while (true) {
            String select = menuSelect();
            if (EXIT.equals(select)) {
                break;
            } else if (ADD.equals(select)) {
                Item item = itemCreate();
                tracker.add(item);
            } else if (SHOWALL.equals(select)) {
                for (Item item : tracker.findAll()) {
                    System.out.println(item.getName() + " " + item.getDesc() + " " + item.getId());
                }
            } else if (EDIT.equals(select)) {
                Item item = itemUpdate();
                tracker.update(item);
            } else if (DELETE.equals(select)) {
                String idDelete = itemID();
                tracker.delete(idDelete);
            } else if (FINDBYID.equals(select)) {
                String id = itemID();
                System.out.println(tracker.findById(id).getName() + " " + tracker.findById(id).getDesc());
            } else if (FINDBYNAME.equals(select)) {
                String name = itemName();
                for (Item item : tracker.findByName(name)) {
                    System.out.println("desc: " + item.getDesc() + " id " + item.getId());
                }
            }
        }
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

    /**
     * Метод itemCreate - создает новую заявку.
     *
     * @return новый item.
     */
    public Item itemCreate() {
        String name = input.ask("Enter name: ");
        String desc = input.ask("Enter desk");
        Item item = new Item(name, desc);
        return item;
    }

    /**
     * Метод itemUpdate - создает item с заданным id.
     *
     * @return новый item.
     */
    public Item itemUpdate() {
        Item item = itemCreate();
        String id = input.ask("Enter id");
        item.setId(id);
        return item;
    }

    /**
     * метод itemID запрашивает ввод id.
     *
     * @return возврашает введенный id.
     */
    public String itemID() {
        String id = input.ask("Enter id");
        return id;
    }

    /**
     * метод itemName запрашивает ввод name.
     *
     * @return возврашает введенное name.
     */
    public String itemName() {
        String name = input.ask("Enter name: ");
        return name;
    }

    public String menuSelect() {
        System.out.print(startMenu);
        String select = input.ask("Select:");
        return select;
    }
}