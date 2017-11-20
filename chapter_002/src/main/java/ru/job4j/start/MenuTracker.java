package ru.job4j.start;

import ru.job4j.models.Item;

/**
 * class MenuTracker.
 *
 * @author Salikov.
 * @version 1.
 */

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];
    private int[] range = {1, 2, 3, 4, 5, 6};

    MenuTracker(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }

    public int[] getRange() {
        return this.range;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAll();
        this.actions[2] = new Edit();
        this.actions[3] = new Delete();
        this.actions[4] = new MenuTracker.FindById(); // new MenuTracker.FindById();
        this.actions[5] = new FindByName();
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public void select(int key) {
        this.actions[key - 1].execute(this.input, this.tracker);
    }

    /**
     * Внутренний класс AddItem.
     */
    private class AddItem implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("enter name: ");
            String desc = input.ask("enter desc: ");
            Item item = new Item(name, desc);
            tracker.add(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }

    /**
     * Внутренний класс ShowAll.
     */
    private class ShowAll implements UserAction {
        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%s. %s. %s", item.getName(), item.getDesc(), item.getId()));
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    private class Edit implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name: ");
            String desc = input.ask("Enter desk: ");
            Item item = new Item(name, desc);
            String id = input.ask("Enter id: ");
            item.setId(id);
            tracker.update(item);
        }


        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }

    /**
     * Внутренний класс Delete.
     */
    private class Delete implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter id: ");
            tracker.delete(id);
        }


        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    /**
     * статический класс FindById.
     */
    private static class FindById implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter id: ");
            Item item = tracker.findById(id);
            System.out.println(item.getName() + " " + item.getDesc());
        }


        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }
    }
}

/**
 * Внешний класс FindByName.
 */
class FindByName implements UserAction {
    public int key() {
        return 6;
    }

    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter name: ");
        for (Item item : tracker.findByName(name)) {
            System.out.println(String.format("%s. %s. %s", item.getName(), item.getDesc(), item.getId()));
        }
    }


    public String info() {
        return String.format("%s. %s", this.key(), "Find items by name");
    }
}


