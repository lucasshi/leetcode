package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/23.
 */
public class P680_ValidPalindrome2 {
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                String leftS = s.substring(left + 1, right + 1);
                String rightS = s.substring(left, right);

                return isPalindrome(leftS) || isPalindrome(rightS);
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        P680_ValidPalindrome2 p = new P680_ValidPalindrome2();
        p.validPalindrome("abcb");
    }
}
