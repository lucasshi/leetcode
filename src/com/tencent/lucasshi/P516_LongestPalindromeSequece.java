package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/17.
 */
public class P516_LongestPalindromeSequece {
    public int longestPalindromeSubseq(String s) {
        String reverseS = new String();
        for (int i = s.length() - 1; i >= 0; i--) {
            reverseS += s.charAt(i);
        }

        // LCS
        int[][] dp = new int[s.length()][s.length()];
        if (s.charAt(0) == reverseS.charAt(0))
            dp[0][0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == reverseS.charAt(0)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }

            if (s.charAt(0) == reverseS.charAt(i)) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(i) == reverseS.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }

                dp[i][j] = Math.max(dp[i][j - 1],
                        Math.max(dp[i - 1][j], dp[i - 1][j - 1]));
            }
        }

        return dp[s.length() - 1][s.length() - 1];
    }

    public static void main(String[] args) {
        P516_LongestPalindromeSequece p = new P516_LongestPalindromeSequece();
        p.longestPalindromeSubseq("bbbab");
    }
}
