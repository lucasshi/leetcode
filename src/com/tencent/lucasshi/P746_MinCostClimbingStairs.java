package com.tencent.lucasshi;

public class P746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[cost.length - 1] = cost[cost.length - 1];
        dp[cost.length - 2] = cost[cost.length - 2];

        int minCost = Integer.MAX_VALUE;
        for (int i = cost.length - 3; i >= 0; i--) {
            dp[i] = Math.min(cost[i] + dp[i + 1], cost[i] + dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }
}
