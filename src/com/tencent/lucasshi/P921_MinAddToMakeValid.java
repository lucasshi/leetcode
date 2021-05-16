package com.tencent.lucasshi;

import java.util.Stack;

public class P921_MinAddToMakeValid {
    public int minAddToMakeValid(String S) {
        int rightCount = 0;
        int matchCount = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                matchCount += 1;
            } else if (c == ')') {
                if (matchCount > 0) {
                    matchCount -= 1;
                } else {
                    rightCount += 1;
                }
            }
        }

        return rightCount + matchCount;
    }

    public static void main(String[] args) {
        P921_MinAddToMakeValid p = new P921_MinAddToMakeValid();
        System.out.println(p.minAddToMakeValid("()))(("));
    }
}
