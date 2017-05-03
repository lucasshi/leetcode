package com.tencent.lucasshi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/5/1.
 */
public class P131_Palindrome {
    public static List<List<String>>[] dpResult = new List[2000];

    public List<List<String>> partition(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }

        // 对称的长度
        for (int length = 1; length < s.length(); length++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + length >= s.length()) {
                    continue;
                }
                if (length == 1) {
                    isPalindrome[i][i + length] = (s.charAt(i) == s.charAt(i + length));
                    continue;
                }

                if (s.charAt(i) != s.charAt(i + length)) {
                    isPalindrome[i][i + length] = false;
                } else {
                    isPalindrome[i][i + length] = isPalindrome[i + 1][i + length - 1];
                }

            }
        }

        helpPartition(s, s.length() - 1, isPalindrome);
        return dpResult[s.length() - 1];
    }

    //
    public void helpPartition(String s, int endIndex, boolean[][] isPalindrome) {
        List<List<String>> results = new ArrayList<>();
        if (endIndex == 0) {
            ArrayList<String> subResult = new ArrayList<>();
            subResult.add(s.charAt(endIndex) + "");
            results.add(subResult);
            dpResult[0] = results;
            return;
        }

        helpPartition(s, endIndex - 1, isPalindrome);
        for (int i = 0; i <= endIndex; i++) {
            if (isPalindrome[i][endIndex]) {
                if (i == 0) {
                    ArrayList<String> subResult = new ArrayList<>();
                    subResult.add(s.substring(i, endIndex + 1));
                    results.add(subResult);
                    continue;
                }
                List<List<String>> subResults = copyList(dpResult[i - 1]);
                for (List<String> subResult : subResults) {
                    subResult.add(s.substring(i, endIndex + 1));
                }
                results.addAll(subResults);
            }
        }

        dpResult[endIndex] = results;
    }

    // copy
    public List<List<String>> copyList(List<List<String>> dpResult) {
        List<List<String>> result = new ArrayList<>();
        //
        for (List<String> subResult : dpResult) {
            List<String> copySubResult = new ArrayList<>();
            copySubResult.addAll(subResult);
            result.add(copySubResult);
        }

        return result;
    }

    public static void main(String[] args) {
        P131_Palindrome p = new P131_Palindrome();
        p.partition("cdd");
    }
}
