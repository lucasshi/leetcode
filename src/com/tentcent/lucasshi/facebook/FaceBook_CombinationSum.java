package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/10/12.
 */

public class FaceBook_CombinationSum {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        helper(res, nums, target, 0);
        return result;
    }

    public void helper(List<Integer> res, int[] nums, int target, int startIndex) {
        if (target == 0) {
            ArrayList<Integer> subResult = new ArrayList<>(res);
            result.add(subResult);
            return;
        }

        if (target < 0)
            return;


        for (int i = startIndex; i < nums.length; i++) {
            res.add(nums[i]);
            helper(res, nums, target - nums[i], i);
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        FaceBook_CombinationSum p = new FaceBook_CombinationSum();
        System.out.println(p.combinationSum(nums, 7));
    }
}
