package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SimpleTreeTest {
    Tree<Integer> tree = new Tree<>(10);

    @Before
    public void setUp() {
        tree.add(10, 5);
        tree.add(10, 9);
        tree.add(10, 3);
        tree.add(9, 2);
        tree.add(9, 31);
        tree.add(2, 331);
        tree.add(5, 20);
        tree.add(3, 12);
    }

    @Test
    public void thenIterator() {
        Iterator iterator = tree.iterator();
        Integer[] result = new Integer[9];
        int i = 0;
        while (iterator.hasNext()) {
            result[i] = (Integer) iterator.next();
            i++;
        }
        Arrays.sort(result);
        assertThat(result, is(new Integer[]{2, 3, 5, 9, 10, 12, 20, 31, 331}));
    }

    @Test
    public void thenFindBy() {
        Integer result = tree.findBy(9).get().getValue();
        assertThat(result, is(9));
    }
}
