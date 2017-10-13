package ru.job4j.condition;
/**
 * Class Point.
 * @author salikov
 * @since 12.10.2017
 * @version 1
 */

public class Point {
    /**
     * x координата.
     */
    private int x;
    /**
     * y координата.
     */
    private int y;

    /**
     * Конструктор - создание нового объекта с определенными значениями.
     * @param x - координата x.
     * @param y - координата y.
     */

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод получения значения поля {@link Point # x}.
     * @return возвращает координату x.
     */

    public int getX() {
        return this.x;
    }

    /**
     * Метод получения значения поля {@link Point # y}.
     * @return возвращает координату y.
     */

    public int getY() {
        return this.y;
    }

    /**
     * Метод is определяет находится ли точка на этой фукнции.
     * @param a - первый аргумент.
     * @param b - второй аргумент.
     * @return возвращает true если точка находится на функции, иначе false.
     */
    public boolean is(int a, int b) {
        boolean result = false;
        if (y == a * x + b) {
            result = true;
        }
            return result;

    }

}