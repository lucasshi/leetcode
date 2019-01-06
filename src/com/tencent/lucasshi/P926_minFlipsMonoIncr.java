package com.tencent.lucasshi;

public class P926_minFlipsMonoIncr {
  public int minFlipsMonoIncr(String S) {
    int[] leftOne = new int[S.length()];
    int[] rightZero = new int[S.length()];

    int oneCount = 0;
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '1') {
        oneCount += 1;
      }
      leftOne[i] = oneCount;
    }

    int zeroCount = 0;
    for (int i = S.length() - 1; i >= 0; i--) {
      if (S.charAt(i) == '1') {
        zeroCount += 1;
      }
      rightZero[i] = zeroCount;
    }

    // do
    for (int i = 0; i < S.length(); i++) {
    }
    return 10;
  }
}
