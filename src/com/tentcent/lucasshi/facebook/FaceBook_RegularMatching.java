package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/3.
 */
public class FaceBook_RegularMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()][p.length()];

        //
        for (int i = 0; i < s.length(); i++) {
            if (p.charAt(0) == '*') {
                dp[i][0] = true;
                continue;
            } else if (p.charAt(0) == '.' && i == 0) {
                dp[i][0] = true;
            } else if (p.charAt(0) == s.charAt(i) && i == 0) {
                dp[i][0] = true;
            }
        }

        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i] = dp[0][i - 1];
            } else if (p.charAt(i) == '.' || p.charAt(i) == s.charAt(0)) {
                dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 1];
            }
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < p.length(); j++) {
                // do
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
                    continue;
                }
            }
        }

        return dp[s.length() - 1][p.length() - 1];
    }

    public static void main(String[] args) {
        FaceBook_RegularMatching p = new FaceBook_RegularMatching();
        System.out.println(p.isMatch("aa","a"));
        System.out.println(p.isMatch("aa","aa"));
        System.out.println(p.isMatch("aaa","aa"));
        System.out.println(p.isMatch("aa", "*"));
        System.out.println(p.isMatch("aa", "a*"));
        System.out.println(p.isMatch("ab", ".*"));
        System.out.println(p.isMatch("aab", "c*a*b"));
    }
}
