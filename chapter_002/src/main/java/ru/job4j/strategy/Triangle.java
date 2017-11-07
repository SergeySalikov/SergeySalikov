package ru.job4j.strategy;

/**
 * Класс Triangle реализующий интерфейс Shape.
 */
public class Triangle implements Shape {
    /**
     * Метод pic формирует треугольник в виде строки.
     *
     * @return - треугольник в виде строки.
     */
    public String pic() {
        StringBuilder pic = new StringBuilder();
        String space = System.getProperty("line.separator");
        pic.append("  +  ");
        pic.append(space);
        pic.append(" + + ");
        pic.append(space);
        pic.append("+++++");
        return pic.toString();
    }
}
