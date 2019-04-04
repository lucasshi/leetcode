package com.tencent.lucasshi;

import java.util.Stack;

public class P921_MinAddToMakeValid {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int rightCount = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.size() != 0) {
                    stack.pop();
                } else {
                    rightCount += 1;
                }
            }
        }

        return rightCount + stack.size();
    }

    public static void main(String[] args) {
        P921_MinAddToMakeValid p = new P921_MinAddToMakeValid();
        System.out.println(p.minAddToMakeValid("()))(("));
    }
}
