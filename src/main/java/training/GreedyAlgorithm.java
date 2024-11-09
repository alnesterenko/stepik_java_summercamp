package training;

public class GreedyAlgorithm {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int pricesLength = prices.length;
        if (pricesLength >= 2) {
            for (int i = 0; i < pricesLength - 1; i++) {
                for (int j = i + 1; j < pricesLength; j++) {
                    if (prices[j] - prices[i] > maxProfit) {
                        maxProfit = prices[j] - prices[i];
                    }
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;
        int result = greedyAlgorithm.maxProfit(prices);
        boolean equals = expected == result;
        System.out.println("Результат соответствует ожидаемому значению: " + equals);
        System.out.println("===========================================");
        prices = new int[]{2, 4, 1};
        expected = 2;
        result = greedyAlgorithm.maxProfit(prices);
        equals = expected == result;
        System.out.println("Результат соответствует ожидаемому значению: " + equals);
    }
}
