package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/10.
 */
public class P242_ValidAnagrams {
    public boolean isAnagram(String s, String t) {
        int[] codeS = new int[26];
        int[] codeT = new int[26];

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            codeS[s.charAt(i) - 'a']++;
            codeT[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++){
            if (codeS[i] != codeT[i])
                return false;
        }

        return true;
    }
}
