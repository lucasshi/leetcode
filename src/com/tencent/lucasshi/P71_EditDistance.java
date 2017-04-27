package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/25.
 */
public class P71_EditDistance {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= length2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // insert
                    int insert = dp[i - 1][j] + 1;
                    int modify = dp[i - 1][j - 1] + 1;
                    int delete = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(insert, Math.min(modify, delete));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
