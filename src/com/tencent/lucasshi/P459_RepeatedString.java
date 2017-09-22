package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 17/9/21.
 */
public class P459_RepeatedString {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null)
            return false;
        if (s.length() <= 1)
            return false;
        for (int i = 2; i <= s.length(); i++) {
            if (s.length() % i != 0)
                continue;
            int charSize = s.length() / i;
            String pivot = "";
            boolean matched = true;
            for (int j = 0; j < i; j++) {
                String value = s.substring(j * charSize, (j + 1) * charSize);
                if (pivot.equals("")) {
                    pivot = value;
                    continue;
                }

                if (!pivot.equals(value)) {
                    matched = false;
                    break;
                }
            }

            if (matched)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        P459_RepeatedString p = new P459_RepeatedString();
        String s = "bb";
        System.out.println(p.repeatedSubstringPattern(s));
    }
}
