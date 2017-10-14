package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/14.
 */
public class FaceBook_MaxProduct {
    public int maxProduct(int[] nums) {
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        // dp
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < maxDp.length; i++) {
            if (nums[i] > 0) {
                maxDp[i] = Math.max(nums[i], maxDp[i] * nums[i]);
                minDp[i] = Math.min(nums[i], minDp[i] * nums[i]);
            } else if (nums[i] == 0) {
                maxDp[i] = minDp[i] = 0;
            } else {
                maxDp[i] = Math.max(nums[i], minDp[i] * nums[i]);
                minDp[i] = Math.max(nums[i], maxDp[i] * nums[i]);
            }
            max = Math.max(maxDp[i], max);
        }

        return max;
    }
}
