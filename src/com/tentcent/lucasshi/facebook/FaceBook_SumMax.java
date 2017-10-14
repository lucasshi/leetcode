package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/13.
 */
public class FaceBook_SumMax {
    public int subArrayMax(int[] nums, int k) {
        int[] subArray = new int[nums.length];
        int sum = 0;
        int window = 0;

        for (int i = 0; i < nums.length; i++) {
            if (window < k) {
                sum += nums[i];
                window++;
                subArray[i] = sum;
                continue;
            }

            sum += nums[i];
            sum -= nums[i - k];
            subArray[i] = sum;
        }

        int dp[][] = new int[nums.length][3];
        int max0 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max0 = Math.max(subArray[i], max0);
            dp[i][0] = max0;
        }

        for (int j = 1; j < 3; j++) {
            for (int i = 0; i < nums.length; i++) {
                dp[i][j] = Math.max(dp[i - 1][j], subArray[i] + dp[i - k][j - 1]);
            }
        }

        return dp[nums.length - 1][2];
    }
}
