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

public class TurnTest {
    /**
     * Test back.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] array = {2, 6, 1, 4};
        String result = Arrays.toString(turn.back(array));
        String expected = "[4, 1, 6, 2]";
        assertThat(result, is(expected));
    }

    /**
     * Test back.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] array = {1, 2, 3, 4, 5};
        String result = Arrays.toString(turn.back(array));
        String expected = "[5, 4, 3, 2, 1]";
        assertThat(result, is(expected));

    }
}