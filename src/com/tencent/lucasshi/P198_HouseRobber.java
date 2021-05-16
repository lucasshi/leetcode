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

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i == 1) {
                dp[i] = nums[i];
            } else if (i == 2) {
                dp[i] = dp[i - 2] + nums[i];
            } else {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            }
        }

        int lastIndex = nums.length - 1;
        return Math.max(dp[lastIndex], dp[lastIndex - 1]);
    }
}
