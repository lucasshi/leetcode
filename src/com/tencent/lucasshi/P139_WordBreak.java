package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by fzy on 17/5/5.
 */
public class P139_WordBreak {
    public static boolean[] dp = new boolean[10000];

    public boolean wordBreak(String s, List<String> wordDict) {
        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }
        HashSet<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }

        wordBreak(s, words);
        return dp[s.length() - 1];
    }

    public void wordBreak(String s, HashSet<String> wordDict) {
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            for (int startIndex = 0; startIndex <= endIndex; startIndex++) {
                String subStr = s.substring(startIndex, endIndex + 1);
                if (wordDict.contains(subStr)) {
                    if (startIndex == 0) {
                        dp[endIndex] = true;
                        break;
                    } else {
                        if (dp[startIndex - 1] == true) {
                            dp[endIndex] = true;
                            break;
                        }
                    }
                }
            }
        }

        return;
    }

    public static void main(String[] args) {
        String s = "abced";
        List<String> wordList = new ArrayList<>();
        wordList.add("b");

        P139_WordBreak p = new P139_WordBreak();
        System.out.println(p.wordBreak("a", wordList));
    }


}
