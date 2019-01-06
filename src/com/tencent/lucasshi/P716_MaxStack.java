package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Stack;

public class P716_MaxStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    public P716_MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.empty() || x > maxStack.peek()) {
            maxStack.push(x);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int mx = maxStack.peek();
        Stack<Integer> t = new Stack<>();
        while (stack.peek() != maxStack.peek()) {
            t.push(stack.peek());
            stack.pop();
            maxStack.pop();
        }
        stack.pop(); maxStack.pop();
        while (!t.empty()) {
            push(t.pop());
        }

        return mx;
    }

    public static void main(String[] args) {
        P716_MaxStack p = new P716_MaxStack();
        p.push(5);
        p.push(1);
        p.push(5);
        p.popMax();
    }
}
