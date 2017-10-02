package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fzy on 17/9/23.
 */
public class Airbnb_MenuOrder {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), candidates, 0, target);
        return result;
    }

    public void dfs(List<Integer> cursors, int[] candidates, int from, int target) {
    }

    public static void main(String[] args) {
        Airbnb_MenuOrder p = new Airbnb_MenuOrder();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(p.combinationSum(candidates, 8));
    }

}
