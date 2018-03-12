package ru.job4j.department;

import java.util.ArrayList;
import java.util.TreeSet;


public class DepartmentAdd {
    public TreeSet<String> addMissing(ArrayList<String> arr) {
        TreeSet<String> data = new TreeSet<>();
        data.addAll(arr);
        for (String temp : arr) {
            data.add(temp.substring(0, temp.lastIndexOf('\\')));
            data.add(temp.substring(0, temp.indexOf('\\')));

        }
        return data;
    }
}
