package com.tencent.lucasshi;

import java.util.Stack;

public class P946_validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int popedIndex = 0;
        int pushedIndex = 0;

        while (pushedIndex < pushed.length || popedIndex < popped.length) {
            if (stack.empty() || stack.peek() != popped[popedIndex]) {
                if (pushedIndex >= pushed.length)
                    return false;
                stack.push(pushed[pushedIndex]);
                pushedIndex++;
            } else {
                stack.pop();
                popedIndex++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        P946_validateStackSequences p946_validateStackSequences = new P946_validateStackSequences();
        int[] pushed = {1,2,3,4,5};
        // int[] poped = {4,3,5,1,2};
        int[] poped1 = {4,5,3,2,1};
        System.out.println(p946_validateStackSequences.validateStackSequences(pushed, poped1));
    }
}
