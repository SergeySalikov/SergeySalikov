package ru.job4j.coin;

public class Coin {
    private int coinValue;

    Coin(int coinValue) {
        this.coinValue = coinValue;
    }
    int getCoinValue() {
        return this.coinValue;
    }
}
