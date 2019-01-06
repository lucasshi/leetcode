package com.tencent.lucasshi;

import java.util.PriorityQueue;

public class P767_ReorganizeString {
    class Pair {
        public char character;
        public int count;

        public Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    public String reorganizeString(String S) {
        char[] alphabet = new char[26];
        for (char c : S.toCharArray()) {
            alphabet[c - 'a']++;
            if (alphabet[c - 'a'] > (S.length() + 1) / 2) {
                return "";
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > 0) {
                pq.add(new int[] {i + 97, alphabet[i]});
            }
        }

        StringBuffer ans = new StringBuffer();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (ans.length() == 0 || first[0] != ans.charAt(ans.length() -1)) {
                ans.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                ans.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return ans.toString();
    }
}
