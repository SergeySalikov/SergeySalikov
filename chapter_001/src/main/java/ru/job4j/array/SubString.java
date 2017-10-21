package ru.job4j.array;

/**
 * class SubString.
 *
 * @author Salikov.
 * @version 1.
 */

class SubString {
    /**
     * Method contains проверяет, что слово находится в другом слове.
     *
     * @param origin - строка для проверки.
     * @param sub    - подстрока для поиска в origin.
     * @return - true если origin содержит в себе sub.
     */
    boolean contains(String origin, String sub) {
        char[] originArray = origin.toCharArray();
        char[] subArray = sub.toCharArray();
        int sizeOrigin = originArray.length;
        int sizeSub = subArray.length;
        boolean result = false;
        for (int out = 0; out < sizeOrigin; out++) {
            if (originArray[out] == subArray[0] & sizeOrigin - out >= sizeSub) {
                int counter = 1;
                int outTemp = out + 1;
                for (int in = 1; in < sizeSub; in++, outTemp++) {
                    if (originArray[outTemp] == subArray[in]) {
                        counter++;
                    }
                }
                if (counter == sizeSub) {
                    result = true;
                    break;
                }
            }


        }
        return result;
    }


}