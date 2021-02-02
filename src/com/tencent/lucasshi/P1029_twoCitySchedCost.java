package com.tencent.lucasshi;

public class P1029_twoCitySchedCost {
    public int twoCitySchedCost(int[][] costs) {
        int size = costs.length / 2;
        int[][] dp = new int[size + 1][size + 1];

        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                int index = i + j - 1;
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    // select the second one
                    dp[i][j] = dp[i][j - 1] + costs[index][1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + costs[index][0];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + costs[index][1], dp[i - 1][j] + costs[index][0]);
                }
            }
        }
        return dp[size][size];
    }

    public static void main(String[] args) {
        int[][] input = {{10,20}, {30,200},{400,50},{30,20}};
        P1029_twoCitySchedCost p1029_twoCitySchedCost = new P1029_twoCitySchedCost();
        System.out.println(p1029_twoCitySchedCost.twoCitySchedCost(input));
    }
}
