package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;

public class P244_shortestDistance2 {
    HashMap<String, ArrayList<Integer>> wordindex = new HashMap<>();

    public P244_shortestDistance2(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!wordindex.containsKey(words[i])) {
                wordindex.put(words[i], new ArrayList<>());
            }
            wordindex.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> word1indexs = wordindex.get(word1);
        ArrayList<Integer> word2indexs = wordindex.get(word2);
        System.out.println(word1indexs);
        System.out.println(word2indexs);

        int index1 = 0;
        int index2 = 0;
        int minDistance = Math.abs(word1indexs.get(index1) - word2indexs.get(index2));
        while (index1 < word1indexs.size() && index2 < word2indexs.size()) {
            minDistance = Math.min(minDistance, Math.abs(word1indexs.get(index1) - word2indexs.get(index2)));
            if (word1indexs.get(index1) < word2indexs.get(index2)) {
                index1 += 1;
            } else {
                index2 += 1;
            }
        }

        for (; index1 < word1indexs.size(); ++index1) {
            minDistance = Math.min(minDistance, Math.abs(word1indexs.get(index1) - word2indexs.get(index2 - 1)));
        }
        for (; index2 < word2indexs.size(); ++index2) {
            minDistance = Math.min(minDistance, Math.abs(word1indexs.get(index1 - 1) - word2indexs.get(index2)));
        }
        return minDistance;
    }

    public static void main(String[] args) {
        String[] words = {"a", "a", "b", "b"};
        P244_shortestDistance2 p = new P244_shortestDistance2(words);
        System.out.println(p.shortest("a", "b"));
        System.out.println(p.shortest("b", "a"));

    }
}
