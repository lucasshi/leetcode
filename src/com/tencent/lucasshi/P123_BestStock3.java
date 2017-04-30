package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/30.
 */
public class P123_BestStock3 {
    // 两次
    // 用动态规划的方法 k表示前面这个分割点作为能获取的最大收益
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int[] dpLeft = new int[prices.length];
        int minValue = prices[0];
        int profit = 0;
        for (int k = 0; k < prices.length; k++) {
            minValue = Math.min(prices[k], minValue);
            profit = Math.max(profit, prices[k] - minValue);
            dpLeft[k] = profit;
        }


        // 右边
        int[] dpRight = new int[prices.length];
        int maxValue = prices[prices.length - 1];
        profit = 0;
        for (int k = prices.length - 1; k >= 0; k--) {
            maxValue = Math.max(prices[k], maxValue);
            profit = Math.max(profit, maxValue - prices[k]);
            dpRight[k] = profit;
        }


        // 一次购买的最大值
        int maxProfit = dpLeft[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            maxProfit = Math.max(dpLeft[i] + dpRight[i + 1], maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] value = {3, 2, 6, 5, 0, 3};
        System.out.println(P123_BestStock3.maxProfit(value));
    }
}
