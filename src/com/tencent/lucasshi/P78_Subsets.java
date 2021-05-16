package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fzy on 17/4/25.
 */
public class P78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    public void helper(int idx, int[] nums, List<List<Integer>> result) {
        if (nums.length - 1 == idx) {
            result.add(new ArrayList<>());
            result.add(new ArrayList<>(Arrays.asList(nums[idx])));
            return;
        }

        helper(idx + 1, nums, result);
        List<List<Integer>> newResult = new ArrayList<>();
        for (List<Integer> subres: result) {
            List<Integer> newSub = new ArrayList<>(subres);
            newSub.add(nums[idx]);
            newResult.add(newSub);
        }

        result.addAll(newResult);
    }


}
