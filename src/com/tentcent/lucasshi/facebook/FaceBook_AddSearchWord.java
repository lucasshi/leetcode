package com.tentcent.lucasshi.facebook;


import sun.text.normalizer.Trie;

import java.util.*;

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

    public boolean searchWord2(String word) {
        List<TrieNode> list = new ArrayList<>();
        list.add(root);
        for (int i = 0; i < word.length(); i++) {
            if (list.size() == 0) {
                return false;
            }

            //
            char c = word.charAt(i);
            List<TrieNode> nextList = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                TrieNode p = list.get(j);
                if (c == '*') {
                    for (Map.Entry<Character, TrieNode> entry : p.childs.entrySet()) {
                        nextList.add(entry.getValue());
                    }
                } else {
                    if (!p.childs.containsKey(c)) {
                        continue;
                    } else {
                        nextList.add(p.childs.get(c));
                    }
                }
            }

            list = nextList;
        }

        return true;
    }

}
