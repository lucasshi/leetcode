package com.tencent.lucasshi;

import java.util.HashMap;

public class P345_lengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> cntMap = new HashMap<>();

        int left = 0;
        int right = 0;
        int length = Integer.MIN_VALUE;
        while (left <= right && left != s.length()) {
            if (cntMap.size() <= k && right != s.length()) {
                cntMap.putIfAbsent(s.charAt(right), 0);
                cntMap.put(s.charAt(right), cntMap.get(s.charAt(right)) + 1);
                right += 1;
            } else {
                cntMap.put(s.charAt(left), cntMap.get(s.charAt(left)) - 1);
                if (cntMap.get(s.charAt(left)) <= 0)
                    cntMap.remove(s.charAt(left));
                left += 1;
            }

            if (cntMap.size() <= k)
                length = Math.max(length, right - left);
        }

        return length;
    }

    public static void main(String[] args) {
        String s = "eceba";
        P345_lengthOfLongestSubstringKDistinct p = new P345_lengthOfLongestSubstringKDistinct();
        System.out.println(p.lengthOfLongestSubstringKDistinct(s, 2));
    }
}
