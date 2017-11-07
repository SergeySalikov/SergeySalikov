package ru.job4j.strategy;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test
 *
 * @author Salikov.
 * @version 1.
 */

public class PaintTest {
    /**
     * Test draw.
     */
    @Test
    public void whenShapeTriangleThenPaintTriangle() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Paint paint = new Paint();
        paint.draw(new Triangle());
        String result = new String(output.toByteArray());
        final String line = System.getProperty("line.separator");
        String expected = String.format("  +  %s + + %s+++++", line, line);
        assertThat(result, is(expected));

    }

    /**
     * Test draw.
     */
    @Test
    public void whenShapeSquareThenPaintSquare() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Paint paint = new Paint();
        paint.draw(new Square());
        String result = new String(output.toByteArray());
        final String line = System.getProperty("line.separator");
        String expected = String.format("++++%s+  +%s+  +%s++++", line, line, line);
        assertThat(result, is(expected));
    }

}
