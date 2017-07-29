package com.tencent.lucasshi;

/**
 * Created by fzy on 17/7/29.
 */
public class P221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        int[][] dp = new int[height][width];
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]),
                        dp[i - 1][j]) + 1;
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }
}
