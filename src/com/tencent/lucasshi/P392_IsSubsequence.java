package com.tencent.lucasshi;

public class P392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (t.charAt(j) == s.charAt(i)) {
                j++;
                i++;
            } else {
                j++;
            }
        }
        return i >= s.length();
    }

    public static void main(String[] args) {
        P392_IsSubsequence p = new P392_IsSubsequence();
        System.out.println(p.isSubsequence("abc", "ahbgdxc"));
    }
}
