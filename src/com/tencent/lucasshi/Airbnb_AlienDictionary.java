package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by fzy on 17/9/22.
 */
public class Airbnb_AlienDictionary {
    public String alienOrder(String[] words) {
        // 构建好了Order数组
        HashMap<Character, Set<Character>> bigOrders = new HashMap<>();
        HashMap<Character, Integer> smallCount = new HashMap<>();
        HashSet<String> pairs = new HashSet<>();

        // 构建数组
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            for (int j = 0; j < word1.length(); j++) {
                if (!smallCount.containsKey(word1.charAt(j)))
                    smallCount.put(word1.charAt(j), 0);
            }

            for (int j = 0; j < word2.length(); j++) {
                if (!smallCount.containsKey(word2.charAt(j)))
                    smallCount.put(word2.charAt(j), 0);
            }

            for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                if (word1.charAt(j) == word2.charAt(j)) {
                    continue;
                }

                // smallorder
                if (!bigOrders.containsKey(word1.charAt(j))) {
                    bigOrders.put(word1.charAt(j), new HashSet<>());
                }

                bigOrders.get(word1.charAt(j)).add(word2.charAt(j));
                String pairKey = word1.charAt(j) + "#" + word2.charAt(j);
                if (!pairs.contains(pairKey)) {
                    smallCount.put(word2.charAt(j), smallCount.get(word2.charAt(j)) + 1);
                    pairs.add(pairKey);
                }
                break;
            }
        }

        String result = "";
        while (!smallCount.isEmpty()) {
            // 选择 = 0的字符
            char zeroChar = 0;
            for (Map.Entry<Character, Integer> entry : smallCount.entrySet()) {
                if (entry.getValue() == 0) {
                    zeroChar = entry.getKey();
                    break;
                }
            }

            // 依赖项减少了
            if (zeroChar == 0)
                return "";
            smallCount.remove(zeroChar);
            if (bigOrders.containsKey(zeroChar)) {
                for (Character c : bigOrders.get(zeroChar)) {
                    smallCount.put(c, smallCount.get(c) - 1);
                }
            }

            result = result + zeroChar;
        }

        return result;
    }

    public static void main(String[] args) {
        //String[] words = {"za", "zb", "ca", "cb"};
//      String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        Airbnb_AlienDictionary p = new Airbnb_AlienDictionary();
        //System.out.println(p.alienOrder(words));
    }
}
