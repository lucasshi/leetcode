package com.tencent.lucasshi;

/**
 * Created by fzy on 17/7/2.
 */
public class P389_findTheDifference {
    public char findTheDifference(String s, String t) {
        int tIndex = 0;
        char result = 0;
        for (int i = 0; i < s.length();i++) {
            if (s.charAt(i) == t.charAt(tIndex)) {
                tIndex++;
                continue;
            }

            return t.charAt(tIndex);
        }

        return t.charAt(tIndex);
    }
}
