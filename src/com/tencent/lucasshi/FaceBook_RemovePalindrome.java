package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/16.
 */
public class FaceBook_RemovePalindrome {
    boolean checkRight(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }

        return true;
    }

    public boolean checkRemoveOne(String s) {
        int misMatchCount = 0;
        int sIndex = 0;
        int eIndex = s.length() - 1;

        // noso
        while (sIndex < eIndex) {
            if (s.charAt(sIndex) == eIndex) {
                sIndex++;
                eIndex--;
                continue;
            }

            // not Match
            String subStr = s.substring(sIndex + 1, eIndex);
            String subStr2 = s.substring(sIndex, eIndex - 1);

            return checkRight(subStr) || checkRight(subStr2);
        }

        return true;
    }
}
