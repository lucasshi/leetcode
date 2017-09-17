package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 17/9/17.
 */
public class P387_FindFirstUnique {
    HashMap<Character, Integer> countMap = new HashMap<>();

    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (!countMap.containsKey(key)) {
                countMap.put(key, 0);
            }

            countMap.put(key, countMap.get(key) + 1);
        }

        for (int i = 0; i < s.length();i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
