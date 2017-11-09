package ru.job4j.start;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.start.StartUI.tracker;

import ru.job4j.models.*;

import org.junit.Test;


/**
 * Test
 *
 * @author Salikov.
 * @version 1.
 */

public class StubInputTest {
    /**
     * Test add.
     */

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "1", "6"});
        StartUI start = new StartUI(input);
        start.init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Test update.
     */

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"2", "test name", "desc", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * Test findAll.
     */
    @Test
    public void whenFindAllThenTrackerHasShowAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item1", "desk1");
        Item item2 = new Item("item2", "desk2");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        Item[] result = tracker.findAll();
        Item[] expected = new Item[]{item1, item2};
        assertThat(result, is(expected));
    }

    /**
     * Test findByID.
     */
    @Test
    public void whenFindByIdThenTrackerHasShowNameAndDesc() {
        Tracker tracker = new Tracker();
        Item item = new Item("item1", "desk1");
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        Item result = tracker.findById(item.getId());
        Item expected = item;
        assertThat(result, is(expected));
    }

    /**
     * Test findByName.
     */
    @Test
    public void whenFindByNameThenTrackerHasShowIDAndDesc() {
        Tracker tracker = new Tracker();
        Item item = new Item("item1", "desk1");
        tracker.add(item);
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        String result = tracker.findByName("item1")[0].getDesc();
        String expected = "desk1";
        assertThat(result, is(expected));
    }


}
