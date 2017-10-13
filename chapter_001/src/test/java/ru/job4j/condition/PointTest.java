package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Sergey Salikov (mailto:sseerrgey@gmail.com)
 * @version 1
 * @since 12.10.2017
 */

public class PointTest {
    /**
     * Test is.
     */
    @Test
    public void whenPointOnLineThenTrue() {
        //create of new point.
        Point a = new Point(2, 6);
        // execute method - is and get result;
        boolean rsl = a.is(2, 2);
        // assert result by excepted value.
        assertThat(rsl, is(true));
    }
}
