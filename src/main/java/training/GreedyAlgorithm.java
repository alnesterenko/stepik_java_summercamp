package training;

public class GreedyAlgorithm {

    public int maxProfit(int[] prices, int fee) {
        int buyPrice = prices[0];
        int maxProfit = 0;
        int globalMaxProfit = 0;
        int pricesLength = prices.length;
        for (int i = 1; i < pricesLength; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else if (prices[i] - buyPrice - fee > maxProfit) {
                maxProfit = prices[i] - buyPrice - fee;
            }
        }
        globalMaxProfit = Math.max(globalMaxProfit, maxProfit);
        buyPrice = prices[0];
        maxProfit = 0;
        for (int i = 1; i < pricesLength; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else if (prices[i] - buyPrice - fee > 1) {
                maxProfit += prices[i] - buyPrice - fee;
                if (i < pricesLength - 1) {
                    buyPrice = prices[i + 1];
                }
            }
        }
        globalMaxProfit = Math.max(globalMaxProfit, maxProfit);
        return globalMaxProfit;
    }

    public static void main(String[] args) {
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int expected = 8;
        int result = greedyAlgorithm.maxProfit(prices, fee);
        System.out.println("Ожидаемое значение: " + expected + " Полученный результат: " + result);
        System.out.println("===========================================");
        prices = new int[] {1, 3, 7, 5, 10, 3};
        fee = 3;
        expected = 6;
        result = greedyAlgorithm.maxProfit(prices, fee);
        System.out.println("Ожидаемое значение: " + expected + " Полученный результат: " + result);
    }
}
