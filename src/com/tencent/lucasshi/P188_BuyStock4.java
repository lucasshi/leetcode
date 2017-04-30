package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/30.
 */
public class P188_BuyStock4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // validate input 1
        if (k <= 0 || n == 0) return 0;

        // validate input 2 : if k is large enough, the question will be the same as question II.
        if (k >= n / 2) {
            int result = 0;
            for (int i = 1; i < n; ++i) {
                if (prices[i] - prices[i - 1] > 0) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }

        // local是以K作为结尾的的交易
        int[][] localProfit = new int[n][k + 1];
        int[][] globalProfit = new int[n][k + 1];
        for (int j = 1; j <= k; ++j) {
            for (int i = 1; i < n; ++i) {
                localProfit[i][j] = Math.max(
                        localProfit[i - 1][j] + prices[i] - prices[i - 1],
                        globalProfit[i - 1][j - 1] + Math.max(0, prices[i] - prices[i - 1]));
                globalProfit[i][j] = Math.max(localProfit[i][j], globalProfit[i - 1][j]);
            }
        }

        return globalProfit[n - 1][k];
    }
}
