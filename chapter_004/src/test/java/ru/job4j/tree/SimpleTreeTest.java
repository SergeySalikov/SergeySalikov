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
        tree.add(10, 9);
        tree.add(9, 2);
        tree.add(9, 31);
        tree.add(9, 31);
        tree.add(2, 331);
        tree.add(2, 9);
        tree.add(2, 1233);
        tree.add(2, 3122);
        tree.add(5, 20);
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
        assertThat(result, is(new Integer[]{2, 5, 9, 10, 20, 31, 331, 1233, 3122}));
    }

    @Test
    public void thenFindBy() {
        Integer result = tree.findBy(9).get().getValue();
        assertThat(result, is(9));
    }

    @Test
    public void thenIsBinary() {
        assertThat(tree.isBinary(), is(false));
    }
}
