package ru.job4j.loop;
/**
 * Class Paint рисует пирамиду.
 *
 * @author Salikov
 * @version 1.
 * @since 16.10.2017.
 */

class Paint {
    /**
     *
     * @param h высота пирамиды
     * @return пирамиду
     */
    public String piramid(int h) {
        StringBuilder builder = new StringBuilder();
        String space = System.getProperty("line.separator");
        for (int out = 1; out <= h; out++) {
            for (int in = 1; in <= h * 2 - 1; in++) {
                if (in < h - out + 1 || in > h + out - 1) {
                    builder.append(' ');
                } else {
                    builder.append('^');
                }
            }
            if (out < h) {
                builder.append(space);
            }
        }
        String result = builder.toString();
        return result;
    }
}