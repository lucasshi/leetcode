package com.tencent.lucasshi;

public class P392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        boolean[][] dp = new boolean[s.length()][t.length()];
        if (s.charAt(0) == t.charAt(0))
            dp[0][0] = true;

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (j > i)
                    continue;
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                // System.out.println(dp[i][j] + " " + s.substring(0, i + 1) + " " + t.substring(0, j + 1));
            }
        }

        return dp[s.length() - 1][t.length() - 1];
    }

    public static void main(String[] args) {
        P392_IsSubsequence p = new P392_IsSubsequence();
        System.out.println(p.isSubsequence("ahbgdx", "abc"));
    }
}
