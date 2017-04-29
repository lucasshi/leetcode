package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/29.
 */
public class P96_uniqueNumTrees {
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // scaning
        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int sepIndex = 0; sepIndex < i; sepIndex++) {
                int leftCount = sepIndex - 0;
                int rightCount = i - sepIndex - 1;

                count += dp[leftCount] * dp[rightCount];
            }

            dp[i] = count;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
