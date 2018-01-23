package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Salikov (mailto:sseerrgey@gmail.com).
 * @version 1
 */
public class ConvertListTest {
    /**
     * Test toList.
     */
    @Test
    public void whenArrayThenList() {
        ConvertList convert = new ConvertList();
        int[][] array = {{1, 5, 4}, {2, 3, 1, 7}, {8, 0, 5}};
        List<Integer> list = convert.toList(array);
        String result = list.toString();
        String expected = "[1, 5, 4, 2, 3, 1, 7, 8, 0, 5]";
        assertThat(result, is(expected));
    }

    /**
     * Test toArray.
     */
    @Test
    public void whenListThenArray() {
        ConvertList convert = new ConvertList();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        int[][] array = convert.toArray(list, 3);
        String result = Arrays.deepToString(array);
        String expected = "[[1, 2, 3], [4, 5, 6], [7, 0, 0]]";
        assertThat(result, is(expected));
    }

    /**
     * Test convert.
     */
    @Test
    public void whenListWithArraysThenList() {
        ConvertList conv = new ConvertList();
        List<int[]> listArray = new ArrayList<>();
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {5, 6};
        int[] array3 = {7, 8, 9};
        listArray.add(array1);
        listArray.add(array2);
        listArray.add(array3);
        List<Integer> list = conv.convert(listArray);
        String result = "[1, 2, 3, 4, 5, 6, 7, 8, 9]";
        String expected = list.toString();
        assertThat(result, is(expected));
    }

}