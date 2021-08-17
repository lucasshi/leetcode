package com.tencent.lucasshi;

import java.util.HashSet;
import java.util.Set;

public class P1647_minDeletion {
    public int minDeletions(String s) {

        // count数组记录input各字母出现的频次
        int[] count = new int[26];
        int deletion = 0;
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        //用一个set来记录出现频次 以保证唯一
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int freq = count[i];

            //看看这个频次是不是已经有了 有的话就得做delete
            while (freq > 0 && !unique.add(freq)) {
                freq--;
                deletion++;
            }
        }
        return deletion;
    }
}
