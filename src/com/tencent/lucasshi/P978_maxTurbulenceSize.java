package com.tencent.lucasshi;

public class P978_maxTurbulenceSize {
    public int maxTurbulenceSize(int[] A) {
        int[][] dp = new int[A.length][2];

        dp[0][0] = 1;
        dp[0][1] = 1;

        int max = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = 1;
            } else if (A[i] < A[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = 1;
            } else {
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
            max = Math.max(dp[i][0], Math.max(max, dp[i][1]));
        }

        return max;
    }

    public static void main(String[] args) {
        P978_maxTurbulenceSize p = new P978_maxTurbulenceSize();
        // int[] A = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int[] A = {4, 8, 12, 16};
        System.out.println(p.maxTurbulenceSize(A));
    }
}
