package ru.job4j.start;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import ru.job4j.models.*;

import org.junit.Test;


/**
 * Test.
 *
 * @author Sergey Salikov (mailto:sseerrgey@gmail.com).
 * @version 1
 */

public class TrackerTest {
    /**
     * Test add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Test update.
     */
    @Test
    public void whenUpdateItemThenReturnNewItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.update(next);
        String result = tracker.findById(next.getId()).getName();
        String expected = "test2";
        assertThat(result, is(expected));
    }

    /**
     * Test delete.
     */
    @Test
    public void whenDeleteItemThenItemsWithoutDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 223L);
        tracker.add(item1);
        tracker.add(item2);
        item1.setId("11");
        tracker.delete("11");
        boolean expected = true;
        boolean result = tracker.findAll()[0].getId().equals(item2.getId());
        assertThat(result, is(expected));

    }

    /**
     * Test findAll.
     */
    @Test
    public void whenFindAllThenArrayWithoutNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item2);
        Item[] itemArray = tracker.findAll();
        int result = itemArray.length;
        int expected = 2;
        assertThat(result, is(expected));

    }

    /**
     * Test findByName.
     */
    @Test
    public void whenFindByNameThenArrayItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription25225", 123L);
        Item item3 = new Item("test1", "testDescription31", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = tracker.findByName("test1");
        Item[] expected = {item1, item3};
        assertThat(result, is(expected));

    }

    /**
     * Test findById.
     */
    @Test
    public void whenFindByIdThenItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription25225", 123L);
        Item item3 = new Item("test1", "testDescription31", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        item2.setId("test");
        Item result = tracker.findById("test");
        Item expected = item2;
        assertThat(result, is(expected));

    }


}