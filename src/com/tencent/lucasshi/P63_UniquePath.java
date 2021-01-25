package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/24.
 */
public class P63_UniquePath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int hLength = obstacleGrid.length;
        int vLength = obstacleGrid[0].length;

        int[][] dp = new int[hLength][vLength];
        dp[0][0] = obstacleGrid[0][0] == 0? 1: 0;

        for (int i = 0; i < hLength; i++) {
            for (int j = 0; j < vLength; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (obstacleGrid[i][j] == 1)
                    continue;

                if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[hLength - 1][vLength - 1];
    }
}
