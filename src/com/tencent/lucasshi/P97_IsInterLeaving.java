package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/26.
 */
public class P97_IsInterLeaving {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Size = s1.length();
        int s2Size = s2.length();

        if (s3.length() != s1Size + s2Size) {
            return false;
        }

        boolean dp[][] = new boolean[s1Size + 1][s2Size + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = false;
            }
        }

        for (int i = 1; i <= s2.length(); i++) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1)) {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = false;
            }
        }

        // begin to dp
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }

                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
