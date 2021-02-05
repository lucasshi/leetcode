package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class P1153_canConvert {
    public boolean canConvert(String str1, String str2) {
        final Set<Character> str2set = str2.chars().mapToObj(i -> (char) i).collect(Collectors.toSet());
        if (str2set.size() == 26) {
            return str1.equals(str2);
        }

        if (str1.length() != str2.length())
            return false;

        final HashMap<Character, Character> charMapping = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (!charMapping.containsKey(str1.charAt(i))) {
                charMapping.put(str1.charAt(i), str2.charAt(i));
            } else if (charMapping.get(str1.charAt(i)) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
