package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/20.
 */
public class P377_CombinationSum4 {
    private int count = 0;

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target; i++) {
            dp[i] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int subTarget = i - nums[j];
                if (subTarget >= 0 && dp[subTarget] != 0) {
                    dp[i] += dp[subTarget];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        P377_CombinationSum4 p = new P377_CombinationSum4();
        System.out.println(p.combinationSum4(nums, 4));
    }
}
