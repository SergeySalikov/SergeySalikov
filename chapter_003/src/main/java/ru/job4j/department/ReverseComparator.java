package ru.job4j.department;

import java.util.Comparator;

public class ReverseComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        String[] strArr1 = str1.split("\\\\");
        String[] strArr2 = str2.split("\\\\");
        int result = 0;
        int size = strArr1.length >= strArr2.length ? strArr2.length : strArr1.length;
        for (int i = 0; i < size; i++) {
            if (result == 0) {
                int index1 = Integer.parseInt(strArr1[i].substring(1 + i));
                int index2 = Integer.parseInt(strArr2[i].substring(1 + i));
                result = index2 - index1;
                if (result == 0) {
                    result = strArr1.length - strArr2.length;
                }
            }

        }

        return result;
    }

}
