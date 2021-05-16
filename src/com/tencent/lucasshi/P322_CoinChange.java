package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.Map;

public class P322_CoinChange {
    private Map<Integer, Integer> states = new HashMap<>();

    public int coinChange2(int[] coins, int amount) {
        states = new HashMap<>();
        return helper(coins, amount);
    }

    public int helper(int[] conins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        if (states.containsKey(amount))
            return states.get(amount);

        int result = Integer.MAX_VALUE;
        boolean find = false;
        for (int i = 0; i < conins.length; i++) {
            int res = helper(conins, amount - conins[i]);
            if (res != -1) {
                find = true;
                result = Math.min(result, res + 1);
            }
        }

        states.put(amount, find? result : -1);
        return states.get(amount);
    }

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

    public static void main(String[] args) {
        P322_CoinChange p322_coinChange = new P322_CoinChange();
        int[] conins = {1, 2, 5};
        System.out.println(p322_coinChange.coinChange2(conins, 20));
    }
}
