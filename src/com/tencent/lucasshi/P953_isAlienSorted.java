package com.tencent.lucasshi;

public class P953_isAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (verify(word1, word2, index) == false)
                return false;
        }

        return true;
    }

    public boolean verify(String word1, String word2, int[] index) {
        for (int i = 0; i < word1.length() && i < word2.length(); i++) {
            char word1Char = word1.charAt(i);
            char word2Char = word2.charAt(i);

            if (index[word1Char - 'a'] > index[word2Char - 'a']) {
                return false;
            } else if (index[word1Char - 'a'] < index[word2Char - 'a']) {
                return true;
            }
        }

        return word1.length() <= word2.length();
    }

}
