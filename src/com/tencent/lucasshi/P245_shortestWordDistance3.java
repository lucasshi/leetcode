package com.tencent.lucasshi;

public class P245_shortestWordDistance3 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int word1index = -1;
        int word2index = -1;

        int minDistance = words.length + 1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                word1index = i;
                if (word2index != -1) {
                    minDistance = Math.min(minDistance, word1index - word2index);
                }
            }
            // do
            if (words[i].equals(word2)) {
                word2index = i;
                if (word1index != -1 && word1index != word2index) {
                    minDistance = Math.min(minDistance, word2index - word1index);
                }
            }
        }
        return minDistance;
    }
}
