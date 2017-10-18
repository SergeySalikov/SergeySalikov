package ru.job4j.array;


/**
 * class RotateArray.
 *
 * @author Salikov.
 * @version 1.
 */
class RotateArray {
    /**
     * Метод rotate вращает на 90 градусов квадратный массив.
     *
     * @param array - квадратный массив
     * @return возвращает перевернктый на 90 массив.
     */
    public int[][] rotate(int[][] array) {
        int size = array.length;
        int bound = array.length - 1;
        int[][] arrayResult = new int[size][size];
        for (int out = 0; out < size; out++) {
            for (int in = 0; in < size; in++) {
                arrayResult[in][bound] = array[out][in];
            }
            bound--;
        }
        return arrayResult;
    }
}