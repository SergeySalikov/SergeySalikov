package ru.job4j.max;

/**
 * Class Max для вычисления максимального числа из двух чисел.
 *
 * @author salikov
 * @version 2
 * @since 11.10.2017
 */
public class Max {

    /**
     * Method max вычисляет максимальное число из first и second.
     *
     * @param first  первый аргумент.
     * @param second второй аргумент.
     * @return максимальное число из first и second.
     */
    public int max(int first, int second) {
        int maximum = first > second ? first : second;
        return maximum;
    }

    /**
     * Method max вычисляет максимальное число из first и second.
     *
     * @param first  первый аргумент.
     * @param second второй аргумент.
     * @param third  третий аргумент.
     * @return максимальное число из first, second, third.
     */
    public int max(int first, int second, int third) {
        int maximum = max(max(first, second), third);
        return maximum;
    }
}