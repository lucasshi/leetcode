package com.tencent.lucasshi;

public class P727_minWindow {
    public String minWindow(String S, String T) {
        int[][] dp = new int[S.length()][T.length()];

        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < T.length(); j++) {
                if (j == 0 && S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = 0;
                } else if (S.charAt(i) == T.charAt(j)){
                    for (int k = i - 1; k > 0; k--) {
                        if (dp[k][j - 1] != -1) {
                            dp[i][j] = dp[k][j - 1] + i - k;
                            break;
                        }
                    }
                }
            }
        }

        int length = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < S.length(); i++) {
            if (dp[i][T.length() - 1] < length && dp[i][T.length() - 1] != -1) {
                result = S.substring(i - dp[i][T.length() - 1], i + 1);
                length = dp[i][T.length() - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String S = "abcdebdde";
        String T = "bde";
        P727_minWindow p727_minWindow = new P727_minWindow();
        System.out.println(p727_minWindow.minWindow(S, T));
    }
}
