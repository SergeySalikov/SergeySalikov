package ru.job4j.department;

import java.util.ArrayList;
import java.util.Collections;


public class DepartmentAdd {
    public void addMissing(ArrayList<String> arr) {
        for (int out = 0; out < arr.size(); out++) {
            if (arr.get(out).length() >= 11) {
                if (Collections.frequency(arr, arr.get(out).substring(0, arr.get(out).indexOf("\\"))) < 1) {
                    arr.add(arr.get(out).substring(0, arr.get(out).indexOf("\\")));
                } else if (Collections.frequency(arr, arr.get(out).substring(0, arr.get(out).indexOf("\\", 5))) < 1) {
                    arr.add(arr.get(out).substring(0, arr.get(out).indexOf("\\", 5)));
                }
            }

            if (arr.get(out).length() > 5 && arr.get(out).length() < 9) {
                if (Collections.frequency(arr, arr.get(out).substring(0, arr.get(out).indexOf("\\"))) < 1) {
                    arr.add(arr.get(out).substring(0, arr.get(out).indexOf("\\")));
                }
            }


        }


    }
}
