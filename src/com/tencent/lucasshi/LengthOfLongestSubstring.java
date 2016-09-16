package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 16/9/16.
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndex = new HashMap<>();
        int length = s.length();
        int[] dp = new int[length];
        int maxLength = 0;

        if (length == 0) {
            return maxLength;
        }
        // 查询长度
        dp[0] = 1;
        maxLength = 1;
        charIndex.put(s.charAt(0), 0);
        for (int i = 1; i < length; i++) {
            char key = s.charAt(i);
            // 对于找不到的情况
            if (charIndex.get(key) == null) {
                dp[i] = dp[i - 1] + 1;
            } else {
                int previousIndex = charIndex.get(key);
                if (previousIndex >= (i - dp[i - 1])) {
                    dp[i] = i - previousIndex;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }

            charIndex.put(key, i);
            if (maxLength <= dp[i]) {
                maxLength = dp[i];
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s  = "abcabcbb";
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        int count = l.lengthOfLongestSubstring(s);
        System.out.println(count);
    }
}
