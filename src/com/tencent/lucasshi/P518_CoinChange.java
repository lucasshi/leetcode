package com.tencent.lucasshi;

import java.util.Arrays;

public class P518_CoinChange {

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // do
        for (int j = 0; j < coins.length; j++) {
            for (int i = 0; i < dp.length; i++) {
                if (i >= coins[j]) {
                    dp[i] += dp[i - coins[j]];
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        P518_CoinChange p = new P518_CoinChange();
        System.out.println(p.change(5, new int[]{1, 2, 5}));
    }
}
