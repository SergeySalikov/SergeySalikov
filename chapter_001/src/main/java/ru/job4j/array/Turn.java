package ru.job4j.array;


/**
 * Class Turn.
 *
 * @author Salikov
 * @version 1.
 * @since 17.10.2017.
 */
class Turn {

    /**
     * Method back возвращает перевернутый массив.
     *
     * @param array массив.
     * @return возврашает перевернутый массив.
     */
    public int[] back(int[] array) {
        int middleBound = array.length / 2;
        int upperBound = array.length - 1;
        for (int i = 0; i < middleBound; i++) {
            swap(array, i, upperBound);
            upperBound--;
        }
        return array;
    }

    /**
     * Method swap меняет элементы массива местами.
     *
     * @param array  массив.
     * @param first  - первый элемент.
     * @param second - второй элемент.
     */
    public void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}

