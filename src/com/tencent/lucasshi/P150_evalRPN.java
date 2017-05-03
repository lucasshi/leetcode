package com.tencent.lucasshi;

import java.util.Stack;

/**
 * Created by fzy on 17/5/1.
 */
public class P150_evalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        // do stack
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+")) {
                Integer value1 = stack.pop();
                Integer value2 = stack.pop();

                stack.push(value1 + value2);
                continue;
            }

            // -
            if (token.equals("-")) {
                Integer value1 = stack.pop();
                Integer value2 = stack.pop();

                stack.push(value2 - value1);
                continue;
            }

            if (token.equals("*")) {
                Integer value1 = stack.pop();
                Integer value2 = stack.pop();

                stack.push(value1 * value2);
                continue;
            }

            if (token.equals("/")) {
                Integer value1 = stack.pop();
                Integer value2 = stack.pop();

                stack.push(value2 / value1);
                continue;
            }

            Integer value = Integer.parseInt(token);
            stack.push(value);
        }

        return stack.pop();
    }
}
