package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fzy on 17/10/3.
 */
public class Facebook_GroupAnagram {
    private String getCode(String s) {
        int[] codeArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            codeArray[c - 'a']++;
        }
        String result = "";
        for (int i = 0; i < codeArray.length; i++) {
            result += codeArray[i];
        }

        return result;
    }

    public List<List<String>> groupAnagrams(List<String> stringList) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for (int i = 0; i < stringList.size(); i++) {
            String code = getCode(stringList.get(i));
            if (!groups.containsKey(code)) {
                groups.put(code, new ArrayList<>());
            }
            groups.get(code).add(stringList.get(i));
        }

        return null;
    }
}
