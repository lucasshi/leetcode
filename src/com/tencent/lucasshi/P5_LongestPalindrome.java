package com.tencent.lucasshi;

/**
 * Created by fzy on 16/9/16.
 */
public class P5_LongestPalindrome {
    public String longestPalindrome(String s) {
        int length = s.length();

        // 开始进行设置
        int maxLength = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            // 这种情况是奇数的情况
            int size = Math.min(i - 0, s.length() - 1 - i);
            int pointLength = -1;
            for (int j = 0; j <= size; j++) {
                if (s.charAt(i + j) == s.charAt(i - j)) {
                    pointLength = j;
                } else {
                    break;
                }
            }

            if ((pointLength * 2 + 1 )> maxLength) {
                startIndex = i - pointLength;
                endIndex = i + pointLength;
                maxLength = pointLength * 2 + 1;
            }

            // 偶数的情况
            size = Math.min(i - 0, s.length() - 2 - i);
            pointLength = -1;
            for (int j = 0; j <= size; j++) {
                if (s.charAt(i + 1 + j) == s.charAt(i - j)) {
                    pointLength = j;
                } else {
                    break;
                }
             }

            if (pointLength * 2 + 2 > maxLength) {
                maxLength = pointLength * 2 + 2;
                startIndex = i - pointLength;
                endIndex = i + 1 + pointLength;
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

    public static void main(String[] args) {
        String s = "bb";
        P5_LongestPalindrome solution = new P5_LongestPalindrome();
        System.out.println(solution.longestPalindrome("bb"));
    }
}
