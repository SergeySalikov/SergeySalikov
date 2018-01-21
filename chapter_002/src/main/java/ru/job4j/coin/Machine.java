package ru.job4j.coin;

public class Machine {
    Coin[] arrayCoin = {new Coin(10), new Coin(5), new Coin(2), new Coin(1)};

    int[] changes(int value, int price) {
        int delivery = value - price;
        int size = (delivery / 10) + 3;
        int[] result = new int[size];
        int number = 0;
        for (Coin coin : arrayCoin) {
            int count = delivery / coin.getCoinValue();
            for (int in = number; in < number + count; in++) {
                result[in] = coin.getCoinValue();
            }
            delivery = delivery % coin.getCoinValue();
            number = number + count;
        }
        return result;
    }
}
