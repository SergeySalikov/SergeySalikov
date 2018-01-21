package ru.job4j.array;

import java.util.Arrays;

/**
 * class ArrayDuplicate.
 *
 * @author Salikov.
 * @version 1.
 */

class ArrayDuplicate {
    /**
     * Method remove.
     *
     * @param array - массив строк.
     * @return возвращает массив строк без дубликатов.
     */
    public String[] remove(String[] array) {
        int nElems = array.length;
        for (int out = 0; out < nElems - 1; out++) {
            for (int in = out + 1; in < nElems; in++) {
                if (array[out].equals(array[in])) {
                    swap(array, in, nElems - 1);
                    in--;
                    nElems--;
                }
            }
        }
        return Arrays.copyOf(array, nElems);
    }

    /**
     * Method swap меняет элементы массива местами.
     *
     * @param array  массив.
     * @param first  - первый элемент.
     * @param second - второй элемент.
     */
    public void swap(String[] array, int first, int second) {
        String temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}