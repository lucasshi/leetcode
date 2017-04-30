package com.tencent.lucasshi;

import java.util.List;

/**
 * Created by fzy on 17/4/30.
 */
public class P120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[][] dp = new int[length][length];
        //初始化dp的数据

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE - 1;
        for (int j = 0; j < length; j++) {
            if (dp[length - 1][j] < min) {
                min = dp[length - 1][j];
            }
        }

        return min;
    }
}
