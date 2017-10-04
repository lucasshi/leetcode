package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by fzy on 17/10/3.
 */
public class FaceBook_workBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashDict = new HashSet<>();
        boolean[] dp = new boolean[s.length()];
        ArrayList<Integer> positions = new ArrayList<>();

        hashDict.addAll(wordDict);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (positions.size() == 0) {
                if (hashDict.contains(s.substring(i))) {
                    dp[i] = true;
                    positions.add(i);
                    continue;
                }
            }

            // not zero
            for (int j = 0; j < positions.size(); j++) {
                int position = positions.get(j);
                String sub = s.substring(i, position);
                if (hashDict.contains(sub)) {
                    dp[i] = true;
                    positions.add(i);
                    break;
                }
            }
        }

        for (int i = 0; i < dp.length;i++) {
            System.out.println(dp[i]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        FaceBook_workBreak p = new FaceBook_workBreak();
        ArrayList<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");

        p.wordBreak("leetcode", dict);
    }
}
