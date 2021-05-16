package com.tencent.lucasshi;

public class P1438_longestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        int max = Math.max(nums[0], nums[0]);
        int min = Math.min(nums[0], nums[0]);
        int[] dp = new int[nums.length];
        int longest = -1;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else if (nums[i] <= max && nums[i] >= min) {
                dp[i] = dp[i - 1] + 1;
            } else if (nums[i] > max && nums[i] - min <= limit) {
                dp[i] = dp[i - 1] + 1;
                max = nums[i];
            } else if (nums[i] < min && max - nums[i] <= limit) {
                dp[i] = dp[i - 1] + 1;
                min = nums[i];
            } else {
                int newMax = Integer.MIN_VALUE;
                int newMin = Integer.MAX_VALUE;
                for (int j = i; j >= 0; j--) {
                    newMax = Math.max(nums[j], newMax);
                    newMin = Math.min(nums[j], newMin);
                    if (newMax - newMin > limit) {
                        dp[i] = i - j;
                        break;
                    } else {
                        max = newMax;
                        min = newMin;
                    }
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,4,7,2};
        int limit = 5;
        P1438_longestSubarray p1438_longestSubarray = new P1438_longestSubarray();
        p1438_longestSubarray.longestSubarray(nums, limit);
    }
}
