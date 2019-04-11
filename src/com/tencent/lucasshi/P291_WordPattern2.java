package com.tencent.lucasshi;

import java.util.HashMap;

public class P291_WordPattern2 {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> sets = new HashMap<>();
        return helper(pattern, str, sets);
    }

    public boolean helper(String pattern, String str, HashMap<Character, String> sets) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        char first = pattern.charAt(0);
        if (sets.containsKey(first)) {
            String target = sets.get(first);
            if (!str.startsWith(sets.get(first)))
                return false;
            return helper(pattern.substring(1), str.substring(target.length()), sets);
        }

        for (int i = 1; i <= str.length(); i++) {
            sets.put(first, str.substring(0, i));
            if (helper(pattern.substring(1), str.substring(i), sets)) {
                return true;
            }
        }

        System.out.println(sets);

        return false;
    }

    public static void main(String[] args) {
        String pattern = "d";
        String str = "e";
        P291_WordPattern2 p = new P291_WordPattern2();
        System.out.println(p.wordPatternMatch(pattern, str));
    }
}
