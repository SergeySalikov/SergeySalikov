package ru.job4j.strategy;

/**
 * Класс Square реализует интерфейс Shape.
 */
public class Square implements Shape {
    /**
     * Метод pic формирует квадрат в виде строки.
     *
     * @return -  квадрат в виде строки.
     */
    public String pic() {
        StringBuilder pic = new StringBuilder();
        String space = System.getProperty("line.separator");
        pic.append("++++");
        pic.append(space);
        pic.append("+  +");
        pic.append(space);
        pic.append("+  +");
        pic.append(space);
        pic.append("++++");
        return pic.toString();
    }
}
