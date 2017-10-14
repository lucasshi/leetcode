package com.tentcent.lucasshi.facebook;

import java.util.Stack;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_DecodeString {
  public String decodeString(String input) {
    String result = "";
    String tmpString = "";
    String tmpNumber = "";
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c >= '0' && c <= '9') {
        if (tmpString != "") {
          stack.push(tmpString);
          tmpString = "";
        }
        tmpNumber += c;
      } else if (c == '[') {
        stack.push(tmpNumber);
        tmpNumber = "";
        stack.push("[");
      } else if (c == ']') {
        stack.push(tmpString);
        tmpString = "";
        // pop
        String innerString = "";
        while (!stack.empty()) {
          String s = stack.pop();
          if (s.equals("[")) {
            break;
          }
          innerString = s + innerString;
        }

        // 进行Repeat
        String outputString = "";
        int count = Integer.parseInt(stack.pop());
        for (int j = 0; j < count; j++) {
          outputString += innerString;
        }
        stack.push(outputString);
      } else {
        tmpString += c;
      }
    }

    if (tmpString != "")
      stack.push(tmpString);

    String finalOutput = "";
    while (!stack.empty()) {
      finalOutput = stack.pop() + finalOutput;
    }

    return finalOutput;
  }

  public static void main(String[] args) {
    String input = "3[a2[c]]";
    input = "2[abc]3[cd]ef";
    FaceBook_DecodeString p = new FaceBook_DecodeString();
    System.out.println(p.decodeString(input));
  }
}
