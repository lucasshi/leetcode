package com.tencent.lucasshi;

import java.util.*;

/**
 * Created by fzy on 17/9/17.
 */
public class P451_SortByFrequence {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!freqHashMap.containsKey(s.charAt(i))) {
                freqHashMap.put(s.charAt(i), 0);
            }

            freqHashMap.put(s.charAt(i), freqHashMap.get(s.charAt(i)) + 1);
        }

        // other
        TreeMap<Integer, List<Character>> sortMap = new TreeMap<>();
        for (Map.Entry<Character, Integer> entry : freqHashMap.entrySet()) {
            int cnt = entry.getValue();
            char character = entry.getKey();

            // containsKey
            if (!sortMap.containsKey(cnt)) {
                sortMap.put(cnt, new ArrayList<>());
            }
            sortMap.get(cnt).add(character);
        }

        char[] stringArray = new char[s.length()];
        int index = stringArray.length - 1;
        for (Map.Entry<Integer, List<Character>> entry : sortMap.entrySet()) {
            int cnt = entry.getKey();
            for (Character c : entry.getValue()) {
                for (int i = 0; i < cnt; i++) {
                    stringArray[index] = c;
                    index--;
                }
            }
        }

        return new String(stringArray);
    }
}
