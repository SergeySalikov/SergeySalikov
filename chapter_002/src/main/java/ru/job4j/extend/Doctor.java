package ru.job4j.extend;

/**
 * class Doctor.
 *
 * @author Salikov.
 * @version 1.
 */
public class Doctor extends Profession {
    /**
     * Метод heal - увеличивает health на 5.
     */
    public void heal(Teacher teacher) {
        teacher.health += 5;
    }
}
