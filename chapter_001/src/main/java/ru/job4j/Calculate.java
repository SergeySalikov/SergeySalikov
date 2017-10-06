package ru.job4j;

/**
 * Class Calculate для вывода "Hello world".
 * @author salikov
 * @since 07.10.2017
 * @version 2
 */

class Calculate {
	/**
	* Конструктор, вывод строки в консоль.
	* @param args - args.
	*/
	public static void main(String[] args) {
		System.out.print("Hello world.");
	}
	/**
	* Method echo.
	* @param name Your name.
	* @return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}