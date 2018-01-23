package ru.job4j;

import java.util.ArrayList;
import java.util.List;

/**
 * class ConvertList.
 *
 * @author Salikov.
 * @version 1.
 */

class ConvertList {
    /**
     * @param array -  двумерный массив целых чисел.
     * @return лист содержащий все элементы array.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int out = 0; out < array.length; out++) {
            for (int in = 0; in < array[out].length; in++) {
                list.add(array[out][in]);
            }
        }
        return list;
    }

    /**
     * @param list - лист целых чисел.
     * @param rows - количество строк.
     * @return двумерный массив целых чисел с количеством строк rows.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int columns = 0;
        if (list.size() % rows == 0) {
            columns = list.size() / rows;
        } else if (list.size() % rows != 0) {
            columns = (list.size() / rows) + 1;
        }
        int[][] array = new int[rows][columns];
        int index = 0;
        for (int out = 0; out < array.length; out++) {
            for (int in = 0; in < array[out].length; in++) {
                if (index < list.size()) {
                    array[out][in] = list.get(index);
                    index++;
                } else if (index == list.size()) {
                    array[out][in] = 0;
                }
            }
        }
        return array;
    }

    /**
     * @param list - лист массивов
     * @return лист целых чисел из list.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int value : array) {
                result.add(value);
            }
        }
        return result;
    }
}