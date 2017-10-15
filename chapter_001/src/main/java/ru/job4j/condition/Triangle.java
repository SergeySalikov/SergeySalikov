package ru.job4j.condition;

/**
 * Class Triangle.
 *
 * @author Salikov
 * @version 2
 * @since 13.10.2017
 */

public class Triangle {
    /**
     * точка a.
     */
    private Point a;
    /**
     * точка b.
     */
    private Point b;
    /**
     * точка c.
     */
    private Point c;

    /**
     * Конструктор - создание нового объекта с определенными значениями.
     *
     * @param a - точка a.
     * @param b - точка b.
     * @param c - точка c.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисляет расстояние между точками.
     *
     * @param left  - первая точка.
     * @param right - вторая точка.
     * @return возвращает значение расстояния между точками.
     */
    public double distance(Point left, Point right) {
        double result = Math.sqrt(Math.pow((right.getX() - left.getX()), 2) + Math.pow((right.getY() - left.getY()), 2));
        return result;
    }

    /**
     * Метод вычисляет периметр треугольника.
     *
     * @param ab - расстояние между точками a и b
     * @param ac - расстояние между точками a и c
     * @param bc - расстояние между точками b и c
     * @return возвращает значение расстояния между точками.
     */
    public double period(double ab, double ac, double bc) {
        double perimeter = (ab + ac + bc) / 2;
        return perimeter;
    }

    /**
     * Метод вычисляет площадь треугольника.
     *
     * @return возвращает значение площади треугольника.
     */
    public double area() {
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Метод проверяет возможность построения треугольника.
     *
     * @param ab - расстояние между точками a и b
     * @param ac - расстояние между точками a и c
     * @param bc - расстояние между точками b и c
     * @return возвращает true если возможно, иначе false.
     */
    private boolean exist(double ab, double ac, double bc) {
        boolean result = false;
        if (ab + ac > bc & ab + bc > ac & bc + ac > ab) {
            result = true;
        }
        return result;
    }
}
