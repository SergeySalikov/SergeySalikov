package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ListNodeTest {

    @Test
    public void whenGet() {
        ListNode<Integer> listNodeInt = new ListNode<>();
        listNodeInt.add(10);
        listNodeInt.add(20);
        listNodeInt.add(30);
        listNodeInt.add(15);
        listNodeInt.add(5);
        int resultInt = 5;
        assertThat(resultInt, is(listNodeInt.get(5)));
        resultInt = 10;
        assertThat(resultInt, is(listNodeInt.get(1)));
        resultInt = 30;
        assertThat(resultInt, is(listNodeInt.get(3)));
    }

    @Test
    public void whenIterator() {
        ListNode<Integer> listNodeInt = new ListNode<>();
        listNodeInt.add(10);
        listNodeInt.add(20);
        listNodeInt.add(30);
        listNodeInt.add(15);
        listNodeInt.add(5);
        Iterator it = listNodeInt.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(20));
        assertThat(it.next(), is(30));
        assertThat(it.next(), is(15));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(false));
    }
}
