package com.tencent.lucasshi;

public class P322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            // do
            for (int j = 0; j < coins.length; j++) {
                if (i - j <= 0)
                    continue;
                if (dp[i - j] != -1) {
                    if (dp[i] != -1)
                        dp[i] = Math.min(dp[i], 1 + dp[i - j]);
                    else
                        dp[i] = dp[i - j];
                }
            }
        }

        return dp[amount];
    }
}
