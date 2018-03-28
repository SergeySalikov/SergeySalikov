package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class User {
    String name;
    int children;
    Calendar birthday;
    public User(String name, int children, int years, int months, int days) {
        this.name = name;
        this.children = children;
        birthday = new GregorianCalendar(years, months, days);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}

