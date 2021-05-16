package com.tencent.lucasshi;

import java.util.Stack;

public class P1047_removeDuplicates {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (stack.empty() || stack.peek() != S.charAt(i)) {
                stack.push(S.charAt(i));
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++)
            sb.append(stack.get(i));
        return sb.toString();
    }
}
