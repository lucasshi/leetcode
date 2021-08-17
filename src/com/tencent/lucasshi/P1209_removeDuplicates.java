package com.tencent.lucasshi;

import java.util.Stack;

public class P1209_removeDuplicates {
    class CountInfo {
        public char character;
        public int count;

        CountInfo(char character, int count) {
            this.character = character;
            this.count = count;
        }

        @Override
        public String toString() {
            return "CountInfo{" +
                    "character=" + character +
                    ", count=" + count +
                    '}';
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<CountInfo> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty()) {
                stack.push(new CountInfo(c, 1));
            } else {
                CountInfo peek = stack.peek();
                if (peek.character == c) {
                    CountInfo top = stack.pop();
                    top.count += 1;
                    if (top.count < k)
                        stack.push(top);
                } else {
                    stack.push(new CountInfo(c, 1));
                }
            }
        }

        StringBuffer result = new StringBuffer();
        while (!stack.empty()) {
            CountInfo element = stack.pop();
            for (int i = 0; i < element.count; i++)
                result.append(element.character);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        P1209_removeDuplicates p = new P1209_removeDuplicates();
        System.out.println(p.removeDuplicates("deeedbbcccbdaa", 3));
    }
}
