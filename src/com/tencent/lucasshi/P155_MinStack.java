package com.tencent.lucasshi;

import java.util.Stack;

/**
 * Created by fzy on 17/5/7.
 */
public class P155_MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public P155_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.empty() && minStack.peek() < x) {
             minStack.push(minStack.peek());
            return;
        }

        minStack.push(x);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
