package com.tencent.lucasshi;

import java.util.*;

/**
 * Created by fzy on 17/3/31.
 */
public class P40_CombinationSum2 {
    HashSet<String> dedeupCache = new HashSet<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target, int index) {
        List<List<Integer>> sumList = new ArrayList<>();
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }

            if (candidates[i] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                sumList.add(list);
            }

            List<List<Integer>> resultLists =
                    combinationSum(candidates, target - candidates[i], i + 1);
            for (List<Integer> resultList : resultLists) {
                resultList.add(candidates[i]);
                sumList.add(resultList);
            }
        }

        return sumList;
    }

    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        int sum = 8;
        List<List<Integer>> resultList = P40_CombinationSum2.combinationSum(a, sum, 0);
        System.out.println(resultList.size());
    }
}
