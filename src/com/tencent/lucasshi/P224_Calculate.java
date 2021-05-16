package com.tencent.lucasshi;

import java.util.Stack;

/**
 * Created by fzy on 17/9/10.
 */
public class P224_Calculate {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> integers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        String numberString = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberString += s.charAt(i);
            } else {
                if (numberString.length() != 0) {
                    integers.push(Integer.valueOf(numberString));
                    numberString = "";
                }

                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    operators.push(s.charAt(i));
                } else if (s.charAt(i) == '(') {
                    operators.push(s.charAt(i));
                } else if (s.charAt(i) == ')') {
                    while (operators.peek() != '(') {
                        int val1 = integers.pop();
                        int val2 = integers.pop();
                        char operator = operators.pop();
                        if (operator == '+')
                            integers.push(val1 + val2);
                        else
                            integers.push(val2 - val1);
                    }

                    operators.pop();
                }
            }
        }

        while (!operators.empty()) {
            int val1 = integers.pop();
            int val2 = integers.pop();
            char operator = operators.pop();
            if (operator == '+')
                integers.push(val1 + val2);
            else
                integers.push(val2 - val1);
        }

        return integers.pop();
    }
}
