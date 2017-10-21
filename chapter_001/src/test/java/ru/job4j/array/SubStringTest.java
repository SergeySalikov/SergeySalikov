package ru.job4j.array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


/**
 * Test.
 *
 * @author Sergey Salikov (mailto:sseerrgey@gmail.com).
 * @version 1
 */

public class SubStringTest {
    /**
     * Test contains.
     */
    @Test
    public void whenContainsSubStringThenTrue() {
        SubString subString = new SubString();
        String origin = "Привет";
        String sub = "иве";
        boolean result = subString.contains(origin, sub);
        boolean expected = true;
        assertThat(result, is(expected));
    }


}
