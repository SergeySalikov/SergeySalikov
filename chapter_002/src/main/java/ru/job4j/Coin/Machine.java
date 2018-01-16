package ru.job4j.Coin;

public class Machine {
    Coin[] arrayCoin = {new Coin(10), new Coin(5), new Coin(2), new Coin(1)};


    int[] changes(int value, int price) {
        int delivery = value - price;
        int sizeArray = 0;
        for (Coin coin : arrayCoin) {
            coin.setCount(delivery / coin.getCoinValue());
            delivery = delivery % coin.getCoinValue();
            sizeArray += coin.getCount();
        }

        int[] result = new int[sizeArray];

        for (int in = 0; in < sizeArray; ) {
            for (Coin coin : arrayCoin) {
                while (coin.getCount() > 0) {
                    result[in] = coin.getCoinValue();
                    in++;
                    coin.setCount(coin.getCount() - 1);
                }
            }
        }


        return result;

    }
}
