package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fzy on 17/9/19.
 */
public class P301_RemoveParenthess {
    public HashSet<String> results = new HashSet<>();

    private void dfs(String s, String cur, int index, int lnum, int rnum) {
        if (index == s.length()) {
            if (lnum == rnum) results.add(cur);
            return;
        }

        if (rnum > lnum)
            return;

        // remove
        if (s.charAt(index) == '(') {
            dfs(s, cur, index + 1, lnum, rnum);
        } else if (s.charAt(index) == ')') {
            dfs(s, cur, index + 1, lnum, rnum);
        }

        // not removing
        lnum += s.charAt(index) == '(' ? 1:0;
        rnum += s.charAt(index) == ')' ? 1:0;

        String newCur = cur + s.charAt(index);
        dfs(s, newCur, index + 1, lnum, rnum);
    }

    public void dfsV2(String s, String cur, int lnum, int rnum, int index) {
        if (index == s.length()) {
            if (lnum == rnum)
                results.add(cur);
            return;
        }

        if (rnum > lnum) {
            return;
        }

        if (s.charAt(index) == ')') {
            dfsV2(s, cur, lnum, rnum, index + 1);
            dfsV2(s, cur + ')', lnum, rnum + 1, index + 1);
        } else if (s.charAt(index) == '(') {
            dfsV2(s, cur, lnum, rnum, index + 1);
            dfsV2(s, cur + '(', lnum + 1, rnum, index + 1);
        } else {
            dfsV2(s, cur + s.charAt(index), lnum, rnum, index + 1);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        dfsV2(s, "", 0, 0, 0);

        // List<String> sortedResult = results.stream()
        //         .sorted(Comparator.comparing(String::length).reversed())
        //         .collect(Collectors.toList());
        // List<String> result = new ArrayList<>();
        // int size = sortedResult.get(0).length();
        // for (int i = 0; i < sortedResult.size(); i++) {
        //     if (sortedResult.get(i).length() == size)
        //         result.add(sortedResult.get(i));
        //     if (sortedResult.get(i).length() < size)
        //         break;
        // }
        return null;
        //return results;
    }

    public static void main(String[] args) {
        P301_RemoveParenthess p = new P301_RemoveParenthess();
        p.dfsV2("(a)())()", "", 0, 0, 0);
        System.out.println(p.results);
        // System.out.println(p.removeInvalidParentheses("(a)())()"));


    }
}
