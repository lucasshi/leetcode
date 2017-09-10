package com.tencent.lucasshi;

import java.util.Stack;

/**
 * Created by fzy on 17/9/3.
 */
public class Amazon_baseball_done {
    public static int baseBall(String[] values) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < values.length; i++) {
            String val = values[i];
            if (val.equals("X")) {
                int last = stack.peek();
                stack.push(last * 2);
            } else if (val.equals("+")) {
                int last = stack.pop();
                int nextLast = stack.pop();
                stack.push(nextLast);
                stack.push(last);
                stack.push(last + nextLast);
            } else if (val.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(val));
            }
        }

        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] a = {"5", "-2", "4", "Z", "X", "9", "+", "+"};
        System.out.println(Amazon_baseball_done.baseBall(a));
    }
}
