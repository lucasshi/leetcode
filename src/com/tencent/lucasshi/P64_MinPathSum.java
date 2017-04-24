package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/24.
 */
public class P64_MinPathSum {
    public int minPathSum(int[][] grid) {
        int hLength = grid.length;
        int vLength = grid[0].length;

        int[][] dp = new int[hLength][vLength];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < hLength; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < vLength; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < hLength; i++) {
            for (int j = 1; j < vLength; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[hLength - 1][vLength - 1];
    }
}
