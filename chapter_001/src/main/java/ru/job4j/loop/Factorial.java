package ru.job4j.loop;

/**
 * Class Factorial для подсчета факториала.
 *
 * @author Salikov
 * @version 1.
 * @since 15.10.2017.
 */

class Factorial {
    /**
     * Method calc возвращает рассчитанный факториал для n.
     *
     * @param n - число для расчета факториала.
     * @return факториал.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}