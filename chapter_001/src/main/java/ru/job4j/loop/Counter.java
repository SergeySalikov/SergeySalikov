package ru.job4j.loop;

/**
 * Class Counter для подсчета суммы четных чисел.
 *
 * @author Salikov
 * @version 1.
 * @since 15.10.2017.
 */
class Counter {
    /**
     * Method add вычисляет сумму чётных чисел в диапазоне от start до finish.
     *
     * @param start  - начало диапозона.
     * @param finish - конец диапозона.
     * @return сумму чётных чисел из заданного диапазона.
     */
    public int add(int start, int finish) {
        int sumOfEven = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sumOfEven += i;
            }
        }
        return sumOfEven;
    }
}