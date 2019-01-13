package com.tencent.lucasshi;

public class P402_RemoveKdigits {
    public String removeKdigits(String num, int k) {
        String[][] dp = new String[num.length()][k + 1];

        dp[0][0] = num.substring(0, 1);
        dp[0][1] = "";
        for (int i = 1; i < num.length(); i++) {
            for (int j = 0; j <= k; j++) {
                if (i < j) {
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = num.substring(0, i + 1);
                } else {
                    dp[i][j] = dp[i - 1][j - 1].compareTo(dp[i - 1][j] + num.charAt(i)) < 0 ?
                            dp[i - 1][j - 1] : dp[i - 1][j] + num.charAt(i);
                }
            }
        }

        StringBuffer p = new StringBuffer();
        boolean start = true;
        for (int i = 0; i < dp[num.length() -1][k].length();i++){
            if (dp[num.length() -1][k].charAt(i) == '0' && start)
                continue;
            start = false;
            p.append(dp[num.length() -1][k].charAt(i));
        }

        return p.toString();
    }

    public static void main(String[] args) {
        P402_RemoveKdigits p = new P402_RemoveKdigits();
        System.out.println(p.removeKdigits("10200", 1));
    }
}
