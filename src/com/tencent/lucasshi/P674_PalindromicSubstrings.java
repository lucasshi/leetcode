package com.tencent.lucasshi;

public class P674_PalindromicSubstrings {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count += 1;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count += 1;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (i + j >= s.length() || i - j < 0)
                    break;
                if (s.charAt(i - j) != s.charAt(i + j))
                    break;
                dp[i - j][i + j] = true;
                count += 1;
            }
            if (i + 1 < s.length() && dp[i][i + 1] == true) {
                for (int j = 1; j < s.length(); j++) {
                    if (i + j + 1 >= s.length() || i - j < 0)
                        break;
                    if (s.charAt(i - j) != s.charAt(i + j + 1))
                        break;
                    dp[i - j][i + j + 1] = true;
                    count += 1;
                }
            }
        }
        return count;
    }
}
