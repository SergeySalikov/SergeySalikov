package ru.job4j.loop;

/**
 * Class Board должен рисования шахматной доски из символов x и пробелов.
 *
 * @author Salikov
 * @version 1.
 * @since 15.10.2017.
 */

class Board {
    /**
     * Method paint рисует шахматную доску.
     *
     * @param width  - ширина шахматной доски.
     * @param height - высота шахматной доски.
     * @return шахматную доску.
     */
    public String paint(int width, int height) {

        StringBuilder builder = new StringBuilder();
        for (int out = 1; out <= height; out++) {
            for (int in = 1; in <= width; in++) {
                if (out % 2 != 0) {
                    if (in % 2 == 0) {
                        builder.append(' ');
                    } else {
                        builder.append('x');
                    }
                } else if (out % 2 == 0) {
                    if (in % 2 == 0) {
                        builder.append('x');
                    } else {
                        builder.append(' ');
                    }
                }
            }
            builder.append("\r\n");
        }
        String result = builder.toString();
        return result;
    }
}