package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/14.
 */
public class P198_HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];

        if (nums.length == 2) {
            return Math.max(dp[0], dp[1]);
        }

        // do
        for (int i = 2; i < nums.length; i++) {
            if (i - 3 > 0) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            } else {
                dp[i] = dp[i - 2] + nums[i];
            }
        }

        int lastIndex = nums.length - 1;
        return Math.max(dp[lastIndex], dp[lastIndex - 1]);
    }
}
