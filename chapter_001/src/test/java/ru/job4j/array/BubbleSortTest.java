package ru.job4j.array;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Salikov (mailto:sseerrgey@gmail.com)
 * @version 1
 * @since 17.10.2017
 */

public class BubbleSortTest {
    /**
     * Test sort.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        String result = Arrays.toString(bubbleSort.sort(array));
        String expected = "[0, 1, 1, 2, 3, 4, 5, 5, 7, 8]";
        assertThat(result, is(expected));
    }
}