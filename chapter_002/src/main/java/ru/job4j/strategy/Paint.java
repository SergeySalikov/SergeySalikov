package ru.job4j.strategy;

/**
 * class Paint.
 *
 * @author Salikov.
 * @version 1.
 */
public class Paint {
    /**
     * Метод draw печатает фигуру в зависимости от переданного параметра.
     *
     * @param shape - класс реализующий интерфейс Shape.
     */
    public void draw(Shape shape) {
        System.out.print(shape.pic());
    }
}