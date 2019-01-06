package com.tencent.lucasshi;

public class P32_longestValidParentheses {
  public int longestValidParentheses(String s) {
    int result = 0;
    String res = "";
    int leftCount = 0;
    int rightCount = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        res += s.charAt(i);
        leftCount += 1;
      } else if (rightCount == leftCount) {
        continue;
      } else {
        rightCount += 1;
        res += s.charAt(i);
      }
    }
    return 10;
  }
}
