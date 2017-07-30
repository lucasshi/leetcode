package com.tencent.lucasshi;

/**
 * Created by fzy on 17/7/30.
 */
public class P494_TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (S > sum) {
            return 0;
        }


        int[][] dp = new int[nums.length][sum * 2 + 1];
        dp[0][nums[0] + sum] = 1;
        dp[0][sum - nums[0]] = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < sum * 2 + 1; j++) {
                int num = nums[i];
                int subNum = j + num <= sum * 2 ? dp[i - 1][j + num] : 0;
                int addNum = j - num >= 0 ? dp[i - 1][j - num] : 0;
                dp[i][j] = addNum + subNum;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < sum * 2 + 1; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }

        return S + sum > 2 * sum ? 0 : dp[nums.length - 1][S + sum];
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        int val = 1;
        P494_TargetSum p = new P494_TargetSum();
        p.findTargetSumWays(array, val);
    }
}
