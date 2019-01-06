package com.tentcent.lucasshi.facebook;

import java.util.HashMap;

/**
 * Created by fzy on 17/10/15.
 */
public class FaceBook_IntegerToRoman {
    public int romanToInt(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            int current = map.get(s.charAt(i));
            int next = map.get(s.charAt(i+1));

            if (current >= next) {
                result += current;
            } else {
                result -= current;
            }
        }

        return result;

    }
}
