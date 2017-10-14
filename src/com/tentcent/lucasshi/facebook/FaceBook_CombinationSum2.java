package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fzy on 17/10/13.
 */
public class FaceBook_CombinationSum2 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, nums, 0, target);
        return result;
    }

    public void helper(List<Integer> res, int[] nums, int startIndex, int target) {
        if (target == 0) {
            ArrayList<Integer> subResult = new ArrayList<>(res);
            result.add(subResult);
            return;
        }

        if (target < 0)
            return;

        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            res.add(nums[i]);
            helper(res, nums, i + 1, target - nums[i]);
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        FaceBook_CombinationSum2 p = new FaceBook_CombinationSum2();
        System.out.println(p.combinationSum(nums, 8));
    }
}
