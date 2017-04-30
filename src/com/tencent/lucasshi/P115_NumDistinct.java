package com.tencent.lucasshi;

public class P115_NumDistinct {
    public static int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        if (sLength == 0) {
            return 0;
        }

        if (tLength == 0) {
            return 0;
        }

        // length
        int[][] dp = new int[sLength][tLength];

        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for (int i = 1; i < sLength; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }


        // dp
        for (int i = 1; i < sLength; i++) {
            for (int j = 1; j < t.length(); j++) {
                if (i < j) {
                    dp[i][j] = 0;
                    continue;
                }

                // 相等的时候去
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < sLength; i++) {
            for (int j = 0; j < tLength; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }

        return dp[s.length() - 1][t.length() - 1];
    }

    public static void main(String[] args) {
        P115_NumDistinct.numDistinct("ddd", "dd");
    }
}