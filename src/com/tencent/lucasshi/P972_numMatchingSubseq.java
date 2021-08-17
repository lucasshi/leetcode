package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class P972_numMatchingSubseq {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            index.putIfAbsent(s.charAt(i), new ArrayList<>());
            index.get(s.charAt(i)).add(i);
        }
        return Arrays.stream(words).filter(word -> isSubseq(index, word)).collect(Collectors.toList()).size();
    }

    public boolean isSubseq(HashMap<Character, List<Integer>> index, String word) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < word.length(); i++) {
            if (!index.containsKey(word.charAt(i)))
                continue;
            // do
            char charcter = word.charAt(i);
            List<Integer> characterIndex = index.get(charcter);
            boolean find = false;
            for (int j = 0; j < characterIndex.size(); j++) {
                if (characterIndex.get(j) > min) {
                    min = characterIndex.get(j);
                    find = true;
                    break;
                }
            }

            if (!find)
                return false;
        }

        return true;
    }
}
