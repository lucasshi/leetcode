package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fzy on 17/9/10.
 */
public class P49_GroupAnagram {
    private HashMap<String, List<String>> strings = new HashMap<>();

    public String getCode(String s) {
        int[] intCode = new int[26];
        String result = "";

        // getcode
        for (int i = 0; i < s.length(); i++) {
            intCode[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            result += intCode[i];
        }

        return result;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            String code = getCode(strs[i]);
            if (!strings.containsKey(code)) {
                strings.put(code, new ArrayList<>());
            }

            strings.get(code).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry:strings.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
