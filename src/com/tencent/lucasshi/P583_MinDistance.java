package com.tencent.lucasshi;

/**
 * Created by fzy on 17/7/30.
 */
public class P583_MinDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }

        if (word2.length() == 0) {
            return word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 内容
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        // dp
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                // 我们的内容
                dp[i][j] = Math.min(
                        Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1),
                        dp[i - 1][j - 1] + 2);
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String a = "sea";
        String b = "eat";

        P583_MinDistance p = new P583_MinDistance();
        System.out.println(p.minDistance(a, b));
    }
}
