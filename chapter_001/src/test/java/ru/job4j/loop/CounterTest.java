package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Salikov (mailto:sseerrgey@gmail.com)
 * @version 1
 * @since 15.10.2017
 */
public class CounterTest {
    /**
     * Test add.
     */
    @Test
    public void whenSumEvenNumbersFromZeroToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(0, 10);
        assertThat(result, is(30));
    }
}