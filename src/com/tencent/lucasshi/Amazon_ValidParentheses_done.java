package com.tencent.lucasshi;

import java.util.Stack;

/**
 * Created by fzy on 17/9/3.
 */
public class Amazon_ValidParentheses_done {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // String
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                continue;
            }

            // check
            if (s.charAt(i) == ']') {
                if (stack.empty() || stack.peek() != '[')
                    return false;
                else
                    stack.pop();
            }

            if (s.charAt(i) == ')') {
                if (stack.empty() || stack.peek() != '(')
                    return false;
                else
                    stack.pop();
            }

            if (s.charAt(i) == '}') {
                if (stack.empty() || stack.peek() != '{')
                    return false;
                else
                    stack.pop();
            }
        }

        return stack.empty();
    }
}
