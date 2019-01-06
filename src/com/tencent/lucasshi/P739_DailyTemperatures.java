package com.tencent.lucasshi;

import java.util.Stack;

public class P739_DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = T.length - 1; i > 0; i--) {
            while (!stack.empty() && T[stack.peek()] <= T[i])
                stack.pop();
            if (stack.empty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }
}
