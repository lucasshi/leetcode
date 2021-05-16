package com.tencent.lucasshi;

public class P1231_maximizeSweetness {
    public int maximizeSweetness(int[] sweetness, int K) {
        //
        int[][] dp = new int[sweetness.length][K + 2];
        for (int i = 0; i < sweetness.length; i++) {
            for (int j = 1; j <= K + 1; j++) {
                if (i + 1 < j)
                    continue;

                if (i == 0 && j == 1) {
                    dp[i][j] = sweetness[i];
                } else if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + sweetness[i];
                } else {
                    int sum = 0;
                    for (int t = i; t > 0; t--) {
                        sum += sweetness[t];
                        if (dp[t - 1][j - 1] == 0) {
                            continue;
                        } else {
                            if (dp[i][j] == 0) {
                                dp[i][j] = Math.min(dp[t - 1][j - 1], sum);
                            } else {
                                dp[i][j] = Math.max(Math.min(dp[t - 1][j - 1], sum), dp[i][j]);
                            }

                            if (sum > dp[t - 1][j - 1])
                                break;
                        }
                    }
                }
            }
        }

        return dp[sweetness.length - 1][K + 1];
    }

    public static void main(String[] args) {
        int[] sweetness = {1,2,3,4,5,6,7,8,9};
        int K = 5;
        P1231_maximizeSweetness p1231_maximizeSweetness = new P1231_maximizeSweetness();
        p1231_maximizeSweetness.maximizeSweetness(sweetness, K);
    }
}
