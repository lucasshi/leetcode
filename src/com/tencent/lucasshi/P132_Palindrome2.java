package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/4.
 */
public class P132_Palindrome2 {
    public int minCut(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }

        // 对称的长度
        for (int length = 1; length < s.length(); length++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + length >= s.length()) {
                    continue;
                }
                if (length == 1) {
                    isPalindrome[i][i + length] = (s.charAt(i) == s.charAt(i + length));
                    continue;
                }

                if (s.charAt(i) != s.charAt(i + length)) {
                    isPalindrome[i][i + length] = false;
                } else {
                    isPalindrome[i][i + length] = isPalindrome[i + 1][i + length - 1];
                }

            }
        }

        // doing dp
        int[] minCut = new int[s.length()];
        for (int i = 0; i < minCut.length; i++)
            minCut[i] = Integer.MAX_VALUE;

        minCut[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                // doing dp
                if (i == 0 && j == 0) {
                    continue;
                }

                // doing
                if (isPalindrome[j][i]) {
                    if (j == 0) {
                        minCut[i] = 0;
                        continue;
                    }
                    minCut[i] = Math.min(minCut[j - 1] + 1, minCut[i]);
                }
            }
        }

        return minCut[s.length() - 1];
    }

    public static void main(String[] args) {
        P132_Palindrome2 p = new P132_Palindrome2();
        p.minCut("aab");
    }
}
