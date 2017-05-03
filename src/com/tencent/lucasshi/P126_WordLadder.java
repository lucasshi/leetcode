package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P126_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<Integer, Boolean> visited = new HashMap<>();

        // beginword
        Queue<String> p = new LinkedList<String>();
        Queue<String> q = new LinkedList<String>();

        p.add(beginWord);
        int depth = 1;
        // 进行处理
        while (!p.isEmpty() || !q.isEmpty()) {
            boolean pUsed = false;
            boolean qUsed = false;
            while (!p.isEmpty()) {
                String word = p.poll();
                if (word.equals(endWord)) {
                    return depth;
                }
                for (int i = 0; i < wordList.size(); i++) {
                    if (visited.containsKey(i)) {
                        continue;
                    }
                    if (isWordRight(word, wordList.get(i))) {
                        q.add(wordList.get(i));
                        visited.put(i, true);
                    }
                }
                pUsed = true;
            }

            // addDepth
            if (pUsed) {
                depth++;
            }

            while (!q.isEmpty()) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return depth;
                }
                for (int i = 0; i < wordList.size(); i++) {
                    if (visited.containsKey(i)) {
                        continue;
                    }
                    if (isWordRight(word, wordList.get(i))) {
                        p.add(wordList.get(i));
                        visited.put(i, true);
                    }
                }
                qUsed = true;
            }

            if (qUsed) {
                depth++;
            }
        }

        return 0;
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
            if (diffCount >= 2)
                return false;
        }

        return diffCount == 1;
    }
}