package ru.job4j.extend;

/**
 * class Teacher.
 *
 * @author Salikov.
 * @version 1.
 */
public class Teacher {
    School placeOfWork;
    int health;

    /**
     * Метод teach - увеличивает experience на 2.
     *
     * @param engineer - объект класса Engineer для увеличения experience.
     */
    public void teach(Engineer engineer) {
        engineer.experience += 2;
    }

    public void teach(Doctor doctor) {
        doctor.experience += 2;
    }
}
