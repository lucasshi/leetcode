package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/6.
 */
public class P53_maxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }

        int maxSubArray = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] + nums[i] > dp[i]) {
                dp[i] = dp[i - 1] + nums[i];
            }

            // maxSubArray
            if (dp[i] > maxSubArray) {
                maxSubArray = dp[i];
            }
        }

        return maxSubArray;
    }
}
