package training;

public class GreedyAlgorithm {

    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxProfit = 0;
        int globalMaxProfit = 0;
        int pricesLength = prices.length;
        for (int i = 1; i < pricesLength; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else if (prices[i] - buyPrice > maxProfit) {
                maxProfit = prices[i] - buyPrice;
            }
        }
        globalMaxProfit = Math.max(globalMaxProfit, maxProfit);
        buyPrice = prices[0];
        maxProfit = 0;
        for (int i = 1; i < pricesLength; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else if (prices[i] - buyPrice > 0) {
                maxProfit += prices[i] - buyPrice;
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
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 7;
        int result = greedyAlgorithm.maxProfit(prices);
        System.out.println("Ожидаемое значение: " + expected + " Полученный результат: " + result);
        System.out.println("===========================================");
        prices = new int[] {7, 6, 4, 3, 1};
        expected = 0;
        result = greedyAlgorithm.maxProfit(prices);
        System.out.println("Ожидаемое значение: " + expected + " Полученный результат: " + result);
    }
}
