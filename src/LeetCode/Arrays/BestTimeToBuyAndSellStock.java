package LeetCode.Arrays;

public class BestTimeToBuyAndSellStock {

    //brute force
    public int maxProfit(int[] prices) {
        int n = prices.length, maxProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] > prices[i])
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }


    //Optimised
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
