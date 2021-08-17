package com.tencent.lucasshi;

import java.util.HashSet;

public class P983_mincostTickets {
    public int getMinCostC(int[] dp, int cost, int windowDay, int index, int[] days){
        int minCost = Integer.MAX_VALUE;
        for (int i = index - 1; i >= 0; i--) {
            if (days[index] - days[i] > windowDay)
                return Math.min(minCost, cost + dp[i]);
        }

        return cost;
    }

    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> daySet = new HashSet<>();
        int[] dp = new int[days.length];


        for (int i = 0; i < days.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            // do days = 1

            dp[i] = Math.min(dp[i], getMinCostC(dp, costs[0], 1, i, days));
            dp[i] = Math.min(dp[i], getMinCostC(dp, costs[1], 7, i, days));
            dp[i] = Math.min(dp[i], getMinCostC(dp, costs[2], 30, i, days));
        }

        return dp[dp.length - 1];
    }
}
