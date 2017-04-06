package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/3/29.
 */
public class P39_CombinationSum {

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
                    combinationSum(candidates, target - candidates[i], i);
            for (List<Integer> resultList : resultLists) {
                resultList.add(candidates[i]);
                sumList.add(resultList);
            }
        }

        return sumList;
    }


    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        int sum = 7;
        List<List<Integer>> resultList = P39_CombinationSum.combinationSum(a, sum, 0);
        System.out.println(resultList.size());
    }

}
