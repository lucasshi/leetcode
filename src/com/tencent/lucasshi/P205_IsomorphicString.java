package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 17/5/21.
 */
public class P205_IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (sMap.containsKey(sc)) {
                if (tc != sMap.get(sc)) {
                    return false;
                }
            }

            if (tMap.containsKey(tc)) {
                if (sc != tMap.get(tc)) {
                    return false;
                }
            }

            sMap.put(sc, tc);
            tMap.put(tc, sc);
        }

        return true;
    }
}
