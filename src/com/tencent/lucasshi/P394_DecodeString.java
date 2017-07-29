package com.tencent.lucasshi;

import java.util.Stack;

/**
 * Created by fzy on 17/7/29.
 */
public class P394_DecodeString {
    public boolean isNumber(char c) {
        if (c - '0' <= 9 && c - '0' >= 0) {
            return true;
        }
        return false;
    }

    public String decodeString(String s) {
        String token = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '[' && s.charAt(i) != ']') {
                if (token == "") {
                    token += s.charAt(i);
                    continue;
                }

                if (isNumber(s.charAt(i)) && !isNumber(s.charAt(i - 1))) {
                    stack.push(token);
                    token = "" + s.charAt(i);
                    continue;
                } else if (isNumber(s.charAt(i)) && !isNumber(s.charAt(i - 1))) {
                    stack.push(token);
                    token = "" + s.charAt(i);
                    continue;
                } else {
                    token += s.charAt(i);
                    continue;
                }
            }

            // 准备执行
            if (s.charAt(i) == '[') {
                stack.push(token);
                stack.push("[");
                token = "";
            }

            // 开始进行
            if (s.charAt(i) == ']') {
                if (token != "") {
                    stack.push(token);
                }
                token = "";
                String repeatToken = "";
                while (stack.peek() != "[") {
                    String subToken = stack.pop();
                    repeatToken = subToken + repeatToken;

                }

                // "["
                stack.pop();
                System.out.println(stack.peek());
                int val = Integer.parseInt(stack.pop());

                String repeatedString = "";
                for (int j = 0; j < val; j++) {
                    repeatedString += repeatToken;
                }
                // System.out.println(repeatedString);
                stack.push(repeatedString);
            }
        }

        // 现在就是全部的内容了
        if (token != "") {
            stack.push(token);
        }
        String result = "";
        while (!stack.empty()) {
            result = stack.pop() + result;
        }

        return result;
    }

    // 进行解析
    public static void main(String[] args) {
        String input = "3[a2[c]]";
        input = "2[abc]3[cd]ef";
        P394_DecodeString p = new P394_DecodeString();
        System.out.println(p.decodeString(input));
    }
}
