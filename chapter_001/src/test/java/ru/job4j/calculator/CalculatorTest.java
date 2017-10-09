package ru.job4j.calculator;



import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Salikov (mailto:sseerrgey@gmail.com)
 * @version 1
 * @since 10.10.2017
 */

public class CalculatorTest {
    /**
     * Test add.
     */
    @Test
    public void whenAddOnePlusneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(5, 5);
        double result = calc.getResult();
        double expected = 10;
        assertThat(result, is(expected));
    }

    /**
     * Test subtract.
     */
    @Test
    public void whenSubtractFiveMinusFiveThenZero() {
        Calculator calc = new Calculator();
        calc.subtract(5, 5);
        double result = calc.getResult();
        double expected = 0;
        assertThat(result, is(expected));
    }

    /**
     * Test div.
     */
    @Test
    public void whenDivFiveDivisionFiveThenOne() {
        Calculator calc = new Calculator();
        calc.div(5, 5);
        double result = calc.getResult();
        double expected = 1;
        assertThat(result, is(expected));
    }

    /**
     * Test multiple.
     */
    @Test
    public void whenMultipleFiveMultiplicationFiveThenTwentyFive() {
        Calculator calc = new Calculator();
        calc.multiple(5, 5);
        double result = calc.getResult();
        double expected = 25;
        assertThat(result, is(expected));
    }
}