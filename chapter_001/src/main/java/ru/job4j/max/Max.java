package ru.job4j.max;

/**
 * Class Max для вычисления максимального числа из двух чисел.
 * @author salikov
 * @since 11.10.2017
 * @version 1
 */
public class Max {
    /**
     * first первый аргумент.
     */
   private int first;
    /**
     * second второй аргумент.
     */
   private int second;
    /**
     * Method max вычисляет максимальное число из first и second.
     * @param first первый аргумент.
     * @param second второй аргумент.
     * @return максимальное число из first и second.
     */
   public int max(int first, int second) {
       int maximum = first > second ? first : second;
       return maximum;
   }
}