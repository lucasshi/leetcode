package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/6.
 */
public class P45_JumpGame {
    public int jump(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int step = nums[i];
            for (int j = step; j >= 1; j--) {
                int size = dp[i] + 1;
                if (i + j >= nums.length) {
                    continue;
                } else if (dp[i + j] == -1) {
                    dp[i + j] = size;
                } else {
                    break;
                }
            }
        }

        return dp[nums.length - 1];
    }
}
