package ru.job4j.array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;

/**
 * Test.
 *
 * @author Sergey Salikov (mailto:sseerrgey@gmail.com).
 * @version 1
 */

public class RotateArrayTest {
    /**
     * Test rotate.
     */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        RotateArray rotateArray = new RotateArray();
        int[][] array = {{1, 2}, {3, 4}};
        String result = Arrays.deepToString(rotateArray.rotate(array));
        String expected = "[[3, 1], [4, 2]]";
        assertThat(result, is(expected));
    }

    /**
     * Test rotate.
     */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        RotateArray rotateArray = new RotateArray();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String result = Arrays.deepToString(rotateArray.rotate(array));
        String expected = "[[7, 4, 1], [8, 5, 2], [9, 6, 3]]";
        assertThat(result, is(expected));
    }
}
