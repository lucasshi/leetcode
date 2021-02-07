package com.tencent.lucasshi;

public class P1438_longestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int max = Math.max(nums[0], nums[0]);
        int min = Math.min(nums[0], nums[0]);

        while (right < nums.length) {
            if (Math.abs(max - min) < limit) {
                right += 1;
            }
        }

        return -1;
    }
}
