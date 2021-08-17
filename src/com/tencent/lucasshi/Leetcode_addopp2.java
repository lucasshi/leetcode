package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_addopp2 {
    public List<String> addOperators(String num, int target) {
        List<String> results = new ArrayList<>();
        dfs(num, 0, target, 0, "", results);
        return results;
    }

    public void dfs(String num, int index, int target, int result, String expression, List<String> results) {
        System.out.println(expression);
        if (index == num.length() && result == target)
            results.add(expression);
        if (index == num.length() && result != target)
            return;
        for (int i = index; i < num.length(); i++) {
            int subResult = Integer.valueOf(num.substring(index, i + 1));
            if (expression == "") {
                dfs(num, i + 1, target, result + subResult, "" + subResult, results);
            } else {
                dfs(num, i + 1, target, result + subResult, expression + "+" + subResult, results);
                dfs(num, i + 1, target, result - subResult, expression + "-" + subResult, results);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode_addopp2 leetcode_addopp2 = new Leetcode_addopp2();
        System.out.println(leetcode_addopp2.addOperators("11", 0));
    }
}
