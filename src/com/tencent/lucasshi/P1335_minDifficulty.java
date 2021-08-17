package com.tencent.lucasshi;

public class P1335_minDifficulty {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int[][] dp = new int[jobDifficulty.length][d + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        for (int i = 0; i < jobDifficulty.length; i++) {
            for (int j = 1; j <= d; j++) {
                if (i + 1 < j) {
                   dp[i][j] = -1;
                } else if (j == 1) {
                    dp[i][j]  = getMax(jobDifficulty, 0, i);
                } else {
                    for (int k = 0; k <= i; k++) {
                        if (k -1 >= 0 && dp[k - 1][j - 1] != -1) {
                            if (dp[i][j] == -1)
                                dp[i][j] = dp[k - 1][j - 1] + getMax(jobDifficulty, k, i);
                            else
                                dp[i][j] = Math.min(dp[i][j], dp[k - 1][j - 1] + getMax(jobDifficulty, k, i));
                        }
                    }
                }
            }
        }

        return dp[jobDifficulty.length - 1][d];
    }

    public int getMax(int[] jobDifficulty, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++)
            max = Math.max(jobDifficulty[i], max);
        return max;
    }

    public static void main(String[] args) {
        int[] jobDifficulty = {11,111,22,222,33,333,44,444};
        // int[] jobDifficulty = {7, 1, 7, 1, 7, 1};
        P1335_minDifficulty p = new P1335_minDifficulty();
        System.out.println(p.minDifficulty(jobDifficulty, 6));
    }
}
