package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by fzy on 17/6/30.
 */
public class P187_RepeatedDNA {
    public static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }

        HashSet<String> hashResult = new HashSet<>();
        HashSet<String> hashSet = new HashSet<>();
        // 肯定是>10
        for (int i = 0; i <= s.length() - 10; i++) {
            String subStr = s.substring(i, i + 10);
            if (hashSet.contains(subStr)) {
                hashResult.add(subStr);
            } else {
                hashSet.add(subStr);
            }
        }

        List<String> result = new ArrayList<>();
        for (String val: hashResult) {
            result.add(val);
        }

        return result;
    }

    public static void main(String[] args) {
        String a = "AAAAAAAAAAA";
        P187_RepeatedDNA.findRepeatedDnaSequences("AAAAAAAAAAA");
    }
}
