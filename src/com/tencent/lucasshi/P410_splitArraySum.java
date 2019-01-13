package com.tencent.lucasshi;

public class P410_splitArraySum {
    public int splitArray(int[] nums, int m) {
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }

        int[][] dp = new int[nums.length][m];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }


        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < m; j++) {
                if (i < j) {
                    break;
                }

                if (j == 0) {
                    dp[i][0] = sums[i];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < i; k++) {
                        if (dp[k][j - 1] == -1)
                            continue;
                        dp[i][j] = Math.min(dp[i][j], Math.max(sums[i] - sums[k], dp[k][j - 1]));
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }
        return dp[nums.length - 1][m - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 5, 10};
        P410_splitArraySum p = new P410_splitArraySum();
        System.out.println(p.splitArray(nums, 3));
    }
}
