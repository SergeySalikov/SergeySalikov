package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Iterator;

public class BSTTest {
    BST<Integer> bst = new BST<>(10);

    @Before
    public void setUp() {
        bst.add(15);
        bst.add(2);
        bst.add(7);
        bst.add(32);
        bst.add(1);
        bst.add(22);
        bst.add(8);
    }

    @Test
    public void thenIterator() {
        Integer[] result = new Integer[8];
        Iterator<Integer> iterator = bst.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            result[i++] = iterator.next();
        }
        assertThat(result, is(new Integer[]{1, 2, 7, 8, 10, 15, 22, 32}));
    }
}
