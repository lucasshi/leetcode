package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fzy on 17/7/4.
 */
public class P211_WordDictionary {

    class WordDictionary {
        private TrieNode root;
        private final char NULL_KEY = 0;

        public String reverse(String str) {
            if (str == null || str.length() <= 1) {
                return str;
            }
            return reverse(str.substring(1)) + str.charAt(0);
        }

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
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

            node.subNodes.put(NULL_KEY, new TrieNode());
            return;
        }

        public boolean search(String word) {
            return search(root, word);
        }

        public boolean search(TrieNode wordNode, String word) {
            if (word.length() == 0) {
                return wordNode.subNodes.containsKey(NULL_KEY);
            }

            Character c = word.charAt(0);
            if (!c.equals('.')) {
                if (!wordNode.subNodes.containsKey(c)) {
                    return false;
                } else {
                    return search(wordNode.subNodes.get(c), word.substring(1));
                }
            }

            if (c.equals('.')) {
                for (Map.Entry<Character, TrieNode> entry : wordNode.subNodes.entrySet()) {
                    if (search(entry.getValue(), word.substring(1))) {
                        return true;
                    }
                }

                return false;
            }

            return false;
        }
    }

    class TrieNode {
        public HashMap<Character, TrieNode> subNodes;

        public TrieNode() {
            subNodes = new HashMap<>();
        }
    }
}
