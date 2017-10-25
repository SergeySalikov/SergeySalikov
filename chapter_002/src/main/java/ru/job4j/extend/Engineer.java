package ru.job4j.extend;

/**
 * class Engineer.
 *
 * @author Salikov.
 * @version 1.
 */
public class Engineer extends Profession {
    /**
     * Метод builds создает новый объект класса School и присваивает его полю placeOfWork объекта класса Teacher.
     *
     * @param teacher      - объекта класса Teacher.
     * @param numberSchool - параметр для создание нового объекта класса School.
     * @return созданный объект класса School.
     */
    public School builds(Teacher teacher, int numberSchool) {
        School school = new School(numberSchool);
        teacher.placeOfWork = school;
        return school;
    }
}
