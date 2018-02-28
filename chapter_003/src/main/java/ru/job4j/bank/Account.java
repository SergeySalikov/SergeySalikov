package ru.job4j.bank;

import java.util.Objects;

public class Account {

    private double value;
    private int requisites;

    Account(double value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public int getRequisites() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.value, value) == 0
                && requisites == account.requisites;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, requisites);
    }

    @Override
    public String toString() {
        return "Account{"
                + "value=" + value + ", requisites=" + requisites + '}';
    }
}
