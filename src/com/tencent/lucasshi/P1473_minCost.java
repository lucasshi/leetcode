package com.tencent.lucasshi;

public class P1473_minCost {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // m array length, n number of the color
        int[][][] dp = new int[m][n][target + 1];

        // init
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k <= target; k++)
                    dp[i][j][k] = -1;

        // init
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k <= target; k++) {
                    if (i + 1 < k)
                        continue;

                    if (i == 0 && houses[i] == 0) {
                        dp[i][j][k] = cost[i][j];
                        continue;
                    } else if (i == 0 && houses[i] != 0) {
                        if (houses[i] == j + 1)
                            dp[i][j][k] = 0;
                        continue;
                    }

                    if (houses[i] == 0 || houses[i] == j + 1) {
                        // we could paint the color j
                        // consider not changing the # of target
                        int paintCost = houses[i] == 0 ? cost[i][j] : 0;
                        int cost1 = dp[i - 1][j][k] != -1 ? dp[i - 1][j][k] + paintCost : -1;
                        if (cost1 != -1)
                            dp[i][j][k] = cost1;

                        // count every color
                        int cost2 = -1;
                        for (int t = 0; t < n; t++) {
                            if (t == j || dp[i - 1][t][k - 1] == -1)
                                continue;
                            if (cost2 == -1) {
                                cost2 = dp[i - 1][t][k - 1] + paintCost;
                            } else {
                                cost2 = Math.min(cost2, dp[i - 1][t][k - 1] + paintCost);
                            }
                        }

                        if (dp[i][j][k] == -1)
                            dp[i][j][k] = cost2;
                        else if (cost2 != -1)
                            dp[i][j][k] = Math.min(cost2, dp[i][j][k]);
                    } else if (houses[i] != j + 1) {
                        continue;
                    }
                }
            }
        }

        //
        int min = -1;
        for (int j = 0; j < n; j++) {
            if (dp[m - 1][j][target] == -1)
                continue;
            min = min == -1 ? dp[m - 1][j][target] : Math.min(dp[m - 1][j][target], min);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] houses = {0,2,1,2,0};
        int[][] cost = {{1,10},{10,1},{10,1},{1,10},{5,1}};
        int m = 5;
        int n = 2;
        int target = 3;
        P1473_minCost p1473_minCost = new P1473_minCost();
        System.out.println(p1473_minCost.minCost(houses, cost, m, n, target));
    }
}
