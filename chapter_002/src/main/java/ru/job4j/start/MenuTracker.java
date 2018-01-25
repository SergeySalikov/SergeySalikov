package ru.job4j.start;

import ru.job4j.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * class MenuTracker.
 *
 * @author Salikov.
 * @version 1.
 */

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private int[] range = {0, 1, 2, 3, 4, 5, 6};

    MenuTracker(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }

    public int[] getRange() {
        return this.range;
    }

    public void fillActions() {
        this.actions.add(0, new AddItem("Add new Item", 1));
        this.actions.add(1, new ShowAll("Show all items", 2));
        this.actions.add(2, new Edit("Edit item", 3));
        this.actions.add(3, new Delete("Delete item", 4));
        this.actions.add(4, new MenuTracker.FindById("Find item by Id", 5));
        this.actions.add(5, new FindByName("Find items by name", 6));
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public void select(int key) {
        this.actions.get(key - 1).execute(this.input, this.tracker);
    }

    /**
     * Внутренний класс AddItem.
     */
    private class AddItem extends BaseAction {
        AddItem(String name, int key) {
            super(name, key);
        }

        public int key() {
            return key;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("enter name: ");
            String desc = input.ask("enter desc: ");
            Item item = new Item(name, desc);
            tracker.add(item);
        }
    }

    /**
     * Внутренний класс ShowAll.
     */
    private class ShowAll extends BaseAction {
        ShowAll(String name, int key) {
            super(name, key);
        }

        public int key() {
            return key;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%s. %s. %s", item.getName(), item.getDesc(), item.getId()));
            }
        }
    }


    private class Edit extends BaseAction {
        Edit(String name, int key) {
            super(name, key);
        }

        public int key() {
            return key;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name: ");
            String desc = input.ask("Enter desk: ");
            Item item = new Item(name, desc);
            String id = input.ask("Enter id: ");
            item.setId(id);
            tracker.update(item);
        }
    }

    /**
     * Внутренний класс Delete.
     */
    private class Delete extends BaseAction {
        Delete(String name, int key) {
            super(name, key);
        }

        public int key() {
            return key;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter id: ");
            tracker.delete(id);
        }
    }

    /**
     * статический класс FindById.
     */
    private static class FindById extends BaseAction {
        FindById(String name, int key) {
            super(name, key);
        }

        public int key() {
            return key;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter id: ");
            Item item = tracker.findById(id);
            System.out.println(item.getName() + " " + item.getDesc());
        }
    }
}

/**
 * Внешний класс FindByName.
 */
class FindByName extends BaseAction {
    FindByName(String name, int key) {
        super(name, key);
    }

    public int key() {
        return key;
    }

    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter name: ");
        for (Item item : tracker.findByName(name)) {
            System.out.println(String.format("%s. %s. %s", item.getName(), item.getDesc(), item.getId()));
        }
    }
}


