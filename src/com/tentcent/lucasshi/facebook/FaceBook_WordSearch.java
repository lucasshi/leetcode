package com.tentcent.lucasshi.facebook;

import sun.text.normalizer.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fzy on 17/10/3.
 */
public class FaceBook_WordSearch {
    class TrieNode {
        public HashMap<Character, TrieNode> childs;
    }

    TrieNode root;

    public void search(String s) {
        List<TrieNode> nodeList = new ArrayList<>();
        nodeList.add(root);

        for (int i = 0; i < s.length(); i++) {
            List<TrieNode> nextNodeList = new ArrayList<>();
            if (s.charAt(i) == '.') {
                for (TrieNode trieNode : nodeList) {
                    for (Character c : trieNode.childs.keySet()) {
                        nextNodeList.add(trieNode.childs.get(c));
                    }
                }
                nodeList = nextNodeList;
                continue;
            }

            for (TrieNode trieNode : nodeList) {
                if (trieNode.childs.containsKey(s.charAt(i))) {
                    nextNodeList.add(trieNode.childs.get(s.charAt(i)));
                }
            }
            nodeList = nextNodeList;
        }
    }
}
