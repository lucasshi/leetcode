package com.tencent.lucasshi;

import java.util.Stack;

/**
 * Created by fzy on 17/7/31.
 */
public class P227_BasicCalculate2 {
    public int calculate(String s) {
        int res = 0, d = 0;
        char sign = '+';
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= '0') {
                d = d * 10 + s.charAt(i) - '0';
            }
            if ((s.charAt(i) < '0' && s.charAt(i) != ' ') || i == s.length() - 1) {
                if (sign == '+') nums.push(d);
                if (sign == '-') nums.push(-d);
                if (sign == '*' || sign == '/') {
                    int tmp = sign == '*' ? nums.peek() * d : nums.peek() / d;
                    nums.pop();
                    nums.push(tmp);
                }
                sign = s.charAt(i);
                d = 0;
            }
        }
        while (!nums.empty()) {
            res += nums.peek();
            nums.pop();
        }
        return res;
    }
}
