package ru.job4j.Coin;

public class Coin {
    private int coinValue;
    private int count;

    Coin(int coinValue) {
        this.coinValue = coinValue;
    }

    int getCoinValue() {
        return this.coinValue;
    }

    void setCount(int count) {
        this.count = count;
    }

    int getCount() {
        return this.count;

    }
}
