package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/2.
 */
public class FaceBook_DecodeWays {
  public int numDecodings(String s) {
    int[] dp = new int[s.length()];
    if (dp[0] != '0') {
      dp[0] = 1;
    } else {
      return 0;
    }

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != '0') {
        dp[i] += dp[i - 1];
      }


      if (s.charAt(i - 1) != '0') {
        String val = s.substring(i - 1, i + 1);
        int iVal = Integer.parseInt(val);
        // do
        if (iVal <= 26 && iVal >= 1) {
          if (i - 2 >= 0) {
            dp[i] += dp[i - 2];
          } else {
            dp[i] += 1;
          }
        }
      }
    }

    return dp[s.length() - 1];
  }

  public static void main(String[] args) {
    FaceBook_DecodeWays p = new FaceBook_DecodeWays();
    System.out.println(p.numDecodings("1303"));
  }
}
