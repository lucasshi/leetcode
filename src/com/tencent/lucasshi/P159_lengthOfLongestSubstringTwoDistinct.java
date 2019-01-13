package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.HashSet;

public class P159_lengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> hashes = new HashMap<>();
        int lindex = 0;
        int rindex = 0;

        int maxLength = -1;
        while (rindex < s.length()) {
            if (!hashes.containsKey(s.charAt(rindex)))
                hashes.put(s.charAt(rindex), 0);
            hashes.put(s.charAt(rindex), hashes.get(s.charAt(rindex)) + 1);
            // delete
            while (lindex < rindex && hashes.size() > 2) {
                hashes.put(s.charAt(lindex), hashes.get(s.charAt(lindex)) - 1);
                if (hashes.get(s.charAt(lindex)) == 0)
                    hashes.remove(s.charAt(lindex));
                lindex += 1;
            }
            rindex += 1;
            maxLength = Math.max(maxLength, rindex - lindex);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        P159_lengthOfLongestSubstringTwoDistinct p = new P159_lengthOfLongestSubstringTwoDistinct();
        System.out.println(p.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}

