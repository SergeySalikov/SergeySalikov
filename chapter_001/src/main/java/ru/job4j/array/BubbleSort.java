package ru.job4j.array;


/**
 * class BubbleSort.
 *
 * @author Salikov
 * @version 1.
 * @since 17.10.2017.
 */
class BubbleSort {

    /**
     * Method sort сортирует массив.
     *
     * @param array - массив.
     * @return возвращает отсортированый массив.
     */
    public int[] sort(int[] array) {
        for (int out = array.length - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    swap(array, in, in + 1);
                }
            }

        }
        return array;
    }

    /**
     * Method swap меняет элементы массива местами.
     *
     * @param array  массив.
     * @param first  - первый элемент.
     * @param second - второй элемент.
     */
    public void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}