package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 17/7/3.
 */
public class P208_Trie {
    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (node.subNodes.containsKey(c)) {
                    node = node.subNodes.get(c);
                } else {
                    node.subNodes.put(c, new TrieNode());
                    node = node.subNodes.get(c);
                }
            }

            char key  = 0;
            node.subNodes.put(key, new TrieNode());
            return;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (node.subNodes.containsKey(c)) {
                    node = node.subNodes.get(c);
                } else {
                    return false;
                }
            }

            char key = 0;
            if (node.subNodes.containsKey(key)) {
                return true;
            }

            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                Character c = prefix.charAt(i);
                if (node.subNodes.containsKey(c)) {
                    node = node.subNodes.get(c);
                } else {
                    return false;
                }
            }

            return true;
        }
    }

    class TrieNode {
        public HashMap<Character, TrieNode> subNodes;

        public TrieNode() {
            subNodes = new HashMap<>();
        }
    }
}
