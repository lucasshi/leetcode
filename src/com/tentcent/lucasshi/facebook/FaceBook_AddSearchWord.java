package com.tentcent.lucasshi.facebook;


import java.util.HashMap;

/**
 * Created by fzy on 17/10/8.
 */
public class FaceBook_AddSearchWord {
    class TrieNode {
        public HashMap<Character, TrieNode> childs;
    }

    private TrieNode root;

    public void AddWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.childs.containsKey(word.charAt(i))) {
                p.childs.put(c, new TrieNode());
            }

            p = p.childs.get(c);
        }
    }

    public boolean searchWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.childs.containsKey(c)) {
                return false;
            }
            p = p.childs.get(c);
        }

        return true;
    }

}
