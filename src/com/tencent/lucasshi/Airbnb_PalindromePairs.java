package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by fzy on 17/9/23.
 */
public class Airbnb_PalindromePairs {
    HashMap<String, HashSet<Integer>> wordsDict = new HashMap<>();

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    // do
    public HashSet<List<Integer>> palindromePairs(String[] words) {
        // 构建索引
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int index = 0; index < word.length(); index++) {
                if (isPalindrome(word.substring(0, index))) {
                    if (!wordsDict.containsKey(word.substring(index))) {
                        wordsDict.put(word.substring(index), new HashSet<>());
                    }
                    wordsDict.get(word.substring(index)).add(i);
                }
            }
        }

        HashSet<List<Integer>> result = new HashSet<>();
        // do
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int index = 0;
            for (index = 0; index < word.length() + 1; index++) {
                System.out.println(word.substring(index));

                if (isPalindrome(word.substring(index))) {
                    StringBuffer sb = new StringBuffer(word.substring(0, index));
                    System.out.flush();

                    sb.reverse();
                    String reverseStr = sb.toString();
                    // 包含信息
                    if (wordsDict.containsKey(reverseStr)) {
                        HashSet<Integer> indexSet = wordsDict.get(reverseStr);
                        for (Integer idx : indexSet) {
                            if (idx != i) {
                                List<Integer> subResult = new ArrayList<>();
                                subResult.add(i);
                                subResult.add(idx);
                                result.add(subResult);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] input = {"abcd", "dcba", "lls", "s", "sssll"};
        Airbnb_PalindromePairs p = new Airbnb_PalindromePairs();
        System.out.println(p.palindromePairs(input));
        //System.out.println("abd".substring(0, 0));

    }
}
