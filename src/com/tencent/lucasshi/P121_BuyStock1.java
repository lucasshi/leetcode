package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/30.
 */
public class P121_BuyStock1 {
    public int maxProfit(int[] prices) {
        if (prices.length ==0) {
            return 0;
        }

        int minValue = prices[0];
        int different = 0;

        // do diff
        for (int i = 1; i < prices.length; i++) {
            different = Math.max(different, prices[i] - minValue);
            minValue = Math.min(prices[i], minValue);
        }

        return different;
    }
}
