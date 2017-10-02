package com.tentcent.lucasshi.interview;

import java.util.HashSet;
import java.util.regex.Matcher;

/**
 * Created by fzy on 17/10/2.
 */
public class FaceBook_P76 {
    private int[] tCounts = new int[26];
    private int[] sCounts = new int[26];
    private HashSet<Character> tSet = new HashSet<>();

    public boolean isEqual() {
        for (char c : tSet) {
            if (tCounts[c - 'A'] > sCounts[c - 'A']) {
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tCounts[c - 'A'] += 1;
            tSet.add(c);
        }

        int i = 0;
        int j = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = -1;
        int minEnd = -1;
        while (j < s.length()) {
            if (!isEqual()) {
                sCounts[s.charAt(j) - 'A']++;
                continue;
            }

            if (j - i + 1 < minLength) {
                minStart = i;
                minEnd = j;
                minLength = j - i + 1;
            }
            // equal
            sCounts[s.charAt(i) - 'A']--;
        }

        return s.substring(minStart, minEnd);
    }

    public static void main(String[] args) {
        FaceBook_P76 p = new FaceBook_P76();
        String val = p.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(val);
    }


}
