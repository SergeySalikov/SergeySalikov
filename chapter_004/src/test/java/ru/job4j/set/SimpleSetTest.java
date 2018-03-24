package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    @Test
    public void whenAdd() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(3);
        simpleSet.add(3);
        simpleSet.add(4);
        simpleSet.add(4);
        simpleSet.add(5);
        Iterator it = simpleSet.iterator();
        Integer[] arrInt = new Integer[5];
        int i = 0;
        while (it.hasNext()) {
            arrInt[i++] = (Integer) it.next();
        }
        assertThat(arrInt, is(new Integer[]{1, 2, 3, 4, 5}));
    }
}
