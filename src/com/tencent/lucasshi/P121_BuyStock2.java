package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/30.
 */
public class P121_BuyStock2 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
