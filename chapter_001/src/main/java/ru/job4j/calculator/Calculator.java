package ru.job4j.calculator;

/**
 * Class Calculator для вычисления арифметических операций.
 * @author salikov
 * @since 10.10.2017
 * @version 1
 */
public class Calculator {
	/**
	* Результат вычислений.
	*/
    private double result;

    /**
     * Method add складывает first с second.
     * @param first первый аргумент.
	 * @param second второй аргумент.
     */

    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract вычитает из first second.
     * @param first первый аргумент.
	 * @param second второй аргумент.
     */

    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div делит first на second.
     * @param first первый аргумент.
	 * @param second второй аргумент.
     */

    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiple умножает first на second.
     * @param first первый аргумент.
	 * @param second второй аргумент.
     */

    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult возвращает значение поля result.
     * @return result
     */

    public double getResult() {
        return this.result;
    }
}
