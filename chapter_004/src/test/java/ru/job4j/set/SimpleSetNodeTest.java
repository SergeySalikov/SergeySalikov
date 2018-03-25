package ru.job4j.set;

import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetNodeTest {
    @Test
    public void whenAdd() {
        SimpleSetNode<Integer> simpleSet = new SimpleSetNode<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(4);
        simpleSet.add(5);
        Integer[] result = new Integer[5];
        int i = 0;
        Iterator it = simpleSet.iterator();
        while (it.hasNext()) {
            result[i++] = (Integer) it.next();
        }
        assertThat(result, is(new Integer[]{5, 4, 3, 2, 1}));
    }
}

