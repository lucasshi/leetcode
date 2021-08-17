package com.tencent.lucasshi;

public class P647_countSubstrings {
    public int countSubstrings(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (i - j < 0 || i + j >= s.length())
                    continue;
                if (s.charAt(i + j) == s.charAt(i - j) && dp[i - j + 1][i + j - 1] == true) {
                    dp[i - j][i + j] = true;
                    count += 1;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (i - j + 1 < 0 || i + j >= s.length())
                    continue;
                int lindex = i - j + 1;
                int rindex = i + j;

                if (s.charAt(rindex) == s.charAt(lindex) && rindex - lindex == 1) {
                    dp[lindex][rindex] = true;
                    count += 1;
                } else if (s.charAt(rindex) == s.charAt(lindex) && dp[lindex + 1][rindex - 1] == true) {
                    dp[lindex][rindex] = true;
                    count += 1;
                }
            }
        }

        return count;
    }
}
