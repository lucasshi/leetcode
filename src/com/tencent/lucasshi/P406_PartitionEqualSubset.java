package com.tencent.lucasshi;

/**
 * Created by fzy on 17/7/30.
 */
public class P406_PartitionEqualSubset {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        // 一半
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];

        // 开始的时候都是fase
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                int num = nums[i];
                dp[i][j] = dp[i - 1][j] ||
                        (j - num >= 0 && dp[i - 1][j - num]);
            }
            if (dp[i][target]) {
                return true;
            }
        }

        return true;
    }
}
