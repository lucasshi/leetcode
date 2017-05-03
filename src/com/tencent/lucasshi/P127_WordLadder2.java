package com.tencent.lucasshi;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by fzy on 17/5/2.
 */
public class P127_WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> paths = new HashMap<>();
        HashSet<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);

        Queue<String> p = new LinkedList<>();
        p.offer(beginWord);
        boolean findEndWord = false;

        while (!p.isEmpty()) {
            HashSet<String> levelSet = new HashSet<>();

            while (!p.isEmpty()) {
                String word = p.poll();

                //
                for (String nextWord : wordSet) {
                    if (isWordRight(word, nextWord)) {
                        levelSet.add(nextWord);
                        if (paths.containsKey(nextWord)) {
                            paths.get(nextWord).add(word);
                        } else {
                            LinkedList<String> list = new LinkedList<String>();
                            list.add(word);
                            paths.put(nextWord, list);
                        }

                        if (nextWord.equals(endWord)) {
                            findEndWord = true;
                        }
                    }
                }
            }

            if (findEndWord) {
                break;
            }

            // level set
            for (String nextWord : levelSet) {
                p.add(nextWord);
                wordSet.remove(nextWord);
            }
            levelSet.clear();
        }


        // 现在找到了然后开始DFS
        List<List<String>> results = new ArrayList<>();
        if (findEndWord) {
            DFS(endWord, beginWord, paths, results);
        }

        return results;
    }


    public void DFS(String beginWord, String endWord, HashMap<String, List<String>> path, List<List<String>> results) {
        if (beginWord.equals(endWord)) {
            ArrayList<String> subResult = new ArrayList<>();
            subResult.add(endWord);
            results.add(subResult);
            return;
        }

        List<String> midStrings = path.get(beginWord);
        for (String midString : midStrings) {
            List<List<String>> subResults = new ArrayList<>();
            DFS(midString, endWord, path, subResults);

            // 添加beginWord
            for (List<String> subResult : subResults) {
                subResult.add(beginWord);
            }

            results.addAll(subResults);
        }
    }

    public boolean isWordRight(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int diffCount = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCount++;
            }
            if (diffCount >= 2) {
                return false;
            }
        }

        return diffCount == 1;
    }

    public static void main(String[] args) {
        String beginWord = "red";
        String endWord = "tax";
        String[] wordList = {"ted", "tex", "red", "tax", "tad", "den", "rex", "pee"};
        //String[] wordList = {"hot", "dot", "dog", "lot", "log"};
        //String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        // Do
        P127_WordLadder2 p = new P127_WordLadder2();
        p.findLadders(beginWord, endWord, Arrays.asList(wordList));
    }
}
