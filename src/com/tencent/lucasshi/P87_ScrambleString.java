package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/26.
 */
public class P87_ScrambleString {
    public static boolean isScramble(String s1, String s2) {
        int s1Size = s1.length();
        int s2Size = s2.length();

        if (s1Size != s2Size) {
            return false;
        }

        boolean[][][][] dp = new boolean[s1Size][s1Size][s1Size][s1Size];


        for (int i = 0; i < s1Size; i++) {
            for (int j = 0; j < s1Size; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][i][j][j] = true;
                }
            }
        }

        // i~j之间和a~b之间是不是scramble
        for (int length = 1; length < s1Size; length++) {
            for (int i = 0; i < s1Size; i++) {
                for (int a = 0; a < s1Size; a++) {
                    int j = i + length;
                    int b = a + length;
                    if (j - i != b - a) {
                        dp[i][j][a][b] = false;
                        continue;
                    }

                    if (j > s1Size - 1) {
                        continue;
                    }

                    if (b > s1Size - 1) {
                        continue;
                    }

                    // 其他的情况
                    boolean result = false;
                    for (int k = 0; k < length; k++) {
                        int leftSize = k;
                        int rightSize = j - i - k;
                        System.out.println(a + " " + b + " " + i + " " + j + " " + k + " " + rightSize);
                        if (dp[i][i + k][a][a + k] == true && dp[i + k + 1][j][a + k + 1][b] == true) {
                            result = true;
                            break;
                        }

                        if (dp[i][i + k][b - k][b] == true && dp[i + k + 1][j][a][a + rightSize - 1] == true) {
                            result = true;
                            break;
                        }
                    }

                    dp[i][j][a][b] = result;
                }
            }
        }

        return dp[0][s1Size - 1][0][s1Size - 1];
    }

    public static void main(String[] args) {

        System.out.println("result " + isScramble("ab", "ba"));
    }
}
