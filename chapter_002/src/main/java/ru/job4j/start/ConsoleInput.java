package ru.job4j.start;

import java.util.Scanner;

import ru.job4j.models.*;

/**
 * class ConsoleInput.
 *
 * @version 1.
 * @autor Salikov.
 */
public class ConsoleInput implements Input {
    private String startMenu = ("0.Add new item\n1.Show all items\n2.Edit item\n3.Delete item\n"
            + "4.Find item by id\n5.Find items by name\n6.Exit program\nSelect:");
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод menuSelect - выводит стартовое меню и считывает выбор пользователя.
     *
     * @return возвращает введеное значение пользователем.
     */
    public String menuSelect() {
        String select;
        System.out.print(startMenu);
        select = readSelect();
        return select;
    }

    /**
     * Метод readSelect - считывает данные с консоли.
     *
     * @return возвращает введеное значение пользователем.
     */
    public String readSelect() {
        return scanner.nextLine();
    }

    /**
     * Метод itemCreate - создает новую заявку.
     *
     * @return новый item.
     */
    public Item itemCreate() {
        String name = itemName();
        System.out.println("write desc");
        String desc = scanner.nextLine();
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
        System.out.println("write id");
        item.setId(scanner.nextLine());
        return item;
    }

    /**
     * метод itemID запрашивает ввод id.
     *
     * @return возврашает введенный id.
     */
    public String itemID() {
        System.out.println("write id");
        return scanner.nextLine();
    }

    /**
     * метод itemName запрашивает ввод name.
     *
     * @return возврашает введенное name.
     */
    public String itemName() {
        System.out.println("write name");
        return scanner.nextLine();
    }


    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
