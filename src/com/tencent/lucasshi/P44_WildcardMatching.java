package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/20.
 */
public class P44_WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0)
            return true;
        if (s.length() == 0 && p.equals("*"))
            return true;
        if (s.length() == 0)
            return false;
        if (p.length() == 0)
            return false;
        boolean[][] isMatch = new boolean[s.length()][p.length()];

        // 执行
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                isMatch[i][0] = (p.charAt(0) == '?' || p.charAt(0) == '*'
                        || p.charAt(0) == s.charAt(0));

            }

            if (i != 0) {
                isMatch[i][0] = (p.charAt(0) == '*');
            }
        }

        // 初始化
        int count = p.charAt(0) == '*' ? 0 : 1;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                isMatch[0][i] = isMatch[0][i - 1];
                continue;
            }

            if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(0)) {
                isMatch[0][i] = (count == 0);
                count++;
                continue;
            }

            count++;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < p.length(); j++) {
                if (p.charAt(j) != '*' && p.charAt(j) != '?') {
                    if (s.charAt(i) == p.charAt(j) && isMatch[i - 1][j - 1]) {
                        isMatch[i][j] = true;
                        continue;
                    }
                }

                if (p.charAt(j) == '?') {
                    isMatch[i][j] = isMatch[i - 1][j - 1];
                }

                // 测试
                if (p.charAt(j) == '*') {
                    if (isMatch[i - 1][j] || isMatch[i - 1][j - 1] || isMatch[i][j - 1]) {
                        isMatch[i][j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                System.out.print(isMatch[i][j] + ",");
            }
            System.out.println();
        }

        return isMatch[s.length() - 1][p.length() - 1];
    }

    public static void main(String[] args) {
        /*
        isMatch("aa","a") → false
        isMatch("aa","aa") → true
        isMatch("aaa","aa") → false
        isMatch("aa", "*") → true
        isMatch("aa", "a*") → true
        isMatch("ab", "?*") → true
        isMatch("aab", "c*a*b") → false
        */
        P44_WildcardMatching p = new P44_WildcardMatching();
        /*
        System.out.println(p.isMatch("aa", "a"));
        System.out.println(p.isMatch("aa", "aa"));
        System.out.println(p.isMatch("aaa", "a"));
        System.out.println(p.isMatch("aaa", "*"));
        System.out.println(p.isMatch("aa", "a*"));
        System.out.println(p.isMatch("ab", "?*"));
        */
        System.out.println(p.isMatch("aab", "c*a*b"));
        /*
        System.out.println(p.isMatch("a", "a*"));
        System.out.println(p.isMatch("c", "*?*"));
        */


    }
}
