package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/29.
 */
import java.util.*;

public class P20_ValidParenthess {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }

            if (stack.empty()) {
                return false;
            }

            if (c == '}' && !stack.empty()) {
                char tmp = stack.pop();
                if (tmp != '{') {
                    return false;
                }
            }

            if (c == ']' && !stack.empty()) {
                char tmp = stack.pop();
                if (tmp != '[') {
                    return false;
                }
            }

            if (c == ')' && !stack.empty()) {
                char tmp = stack.pop();
                if (tmp != '(') {
                    return false;
                }
            }
        }

        if (!stack.empty()) {
            return false;
        }

        return true;
    }
}
