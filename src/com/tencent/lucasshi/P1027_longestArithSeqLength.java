package com.tencent.lucasshi;

import java.util.HashMap;

public class P1027_longestArithSeqLength {
    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[nums.length][20000];
        int MAX = 10000;
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i][diff + MAX] = dp[j][diff + MAX] + 1;
                maxLength = Math.max(maxLength,  dp[i][diff + MAX] + 1);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        P1027_longestArithSeqLength p1027_longestArithSeqLength = new P1027_longestArithSeqLength();
        int[] nums = {20,1,15,3,10,5,8};
        System.out.println(p1027_longestArithSeqLength.longestArithSeqLength(nums));
    }
}
