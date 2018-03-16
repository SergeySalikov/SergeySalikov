package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SimpleArrayTest {
    private SimpleArray<Integer> simpleArrInt;

    @Before
    public void setUp() {
        simpleArrInt = new SimpleArray<Integer>(10);
        simpleArrInt.add(1);
        simpleArrInt.add(2);
        simpleArrInt.add(3);
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        Iterator it = simpleArrInt.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenDelete() {
        simpleArrInt.delete(1);
        int result = simpleArrInt.get(1);
        assertThat(result, is(3));

    }

    @Test
    public void whenSet() {
        simpleArrInt.set(2, 10);
        int result = simpleArrInt.get(2);
        assertThat(result, is(10));

    }

    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        SimpleArray<String> simple = new SimpleArray<String>(4);
        simple.add("test");
        String result = simple.get(0);
        assertThat(result, is("test"));
    }

    @Test
    public void whenTypeIntShouldReturnInt() {
        SimpleArray<Integer> simple = new SimpleArray<Integer>(4);
        simple.add(100);
        Integer result = simple.get(0);
        assertThat(result, is(100));
    }
}
