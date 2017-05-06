package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fzy on 17/5/6.
 */
public class P140_WordBreak2 {
    public List<String>[] dp;

    public List<String> wordBreak(String s, List<String> wordDict) {
        dp = new List[s.length()];
        HashSet<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }

        wordBreak(s, words);
        if (dp[s.length() - 1] == null){
            return new ArrayList<String>();
        }
        return dp[s.length() - 1];
    }

    public void wordBreak(String s, HashSet<String> wordDict) {
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            for (int startIndex = 0; startIndex <= endIndex; startIndex++) {
                String subStr = s.substring(startIndex, endIndex + 1);
                if (wordDict.contains(subStr)) {
                    if (startIndex == 0) {
                        if (dp[endIndex] == null) {
                            dp[endIndex] = new LinkedList<>();
                        }
                        dp[endIndex].add(subStr);
                    } else {
                        if (dp[startIndex - 1] == null) {
                            continue;
                        }
                        for (String startStr : dp[startIndex - 1]) {
                            String resultStr = startStr + " " + subStr;
                            if (dp[endIndex] == null) {
                                dp[endIndex] = new LinkedList<>();
                            }
                            dp[endIndex].add(resultStr);
                        }
                    }
                }
            }
        }
        return;
    }
}
