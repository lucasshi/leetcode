package com.tencent.lucasshi;

public class P487_findMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int max = Integer.MIN_VALUE;
        dp[0][0] = nums[0] == 1? 1 : 0;
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][0] = 0;
                dp[i][1] = dp[i - 1][0] + 1;
            }
            max =Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }

    public static void main(String[] args) {
        P487_findMaxConsecutiveOnes p = new P487_findMaxConsecutiveOnes();
        int[] nums = {1,0,1,1,0};
        System.out.println(p.findMaxConsecutiveOnes(nums));
    }
}
