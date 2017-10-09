package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/8.
 */
public class FaceBook_MaxTwoSubArraySum {
    public int maxSubarray(int[] nums) {
        int max = nums[0];
        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i] + nums[i - 1], max + nums[i]);
            maxSoFar = Math.max(max, maxSoFar);
        }

        return maxSoFar;
    }
}
