package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ListArrayTest {

    @Test
    public void thenGet() {
        ListArray<Integer> listArray = new ListArray<>();
        listArray.add(1);
        listArray.add(2);
        listArray.add(3);
        listArray.add(4);
        int result = listArray.get(3);
        assertThat(result, is(4));
        result = listArray.get(0);
        assertThat(result, is(1));
    }

    @Test
    public void thenIterator() {
        ListArray<Integer> listArray = new ListArray<>();
        listArray.add(1);
        listArray.add(2);
        listArray.add(3);
        listArray.add(4);
        Iterator it = listArray.iterator();
        Integer[] result = new Integer[4];
        int i = 0;
        while (it.hasNext()) {
            result[i] = (Integer) it.next();
            i++;
        }
        assertThat(result, is(new Integer[]{1, 2, 3, 4}));
    }

    @Test(expected = NoSuchElementException.class)
    public void thenIteratorExceptionNSEE() {
        ListArray<Integer> listArray = new ListArray<>();
        Iterator it = listArray.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void thenIteratorExceptionCME() {
        ListArray<Integer> listArray = new ListArray<>();
        Iterator it = listArray.iterator();
        listArray.add(1);
        listArray.add(2);
        it.next();
    }

}
