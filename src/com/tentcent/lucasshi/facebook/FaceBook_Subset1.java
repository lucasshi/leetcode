package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/10/14.
 */
public class FaceBook_Subset1 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subs = new ArrayList<>();
        helper2(subs, nums, 0);
        result.add(new ArrayList<>());
        return result;
    }

    public void helper2(List<Integer> subs, int[] nums, int index) {
        if (index == nums.length)
            return;

        for (int i = index; i < nums.length; i++) {
            subs.add(nums[i]);
            result.add(new ArrayList<>(subs));
            helper2(subs, nums, i + 1);
            subs.remove(subs.size() - 1);
        }
    }

    public void helper(List<Integer> subs, int[] nums, int index) {
        if (index >= nums.length) {
            List<Integer> res = new ArrayList<>();
            res.addAll(subs);
            result.add(res);
            return;
        }

        subs.add(nums[index]);
        helper(subs, nums, index + 1);
        subs.remove(subs.size() - 1);
        helper(subs, nums, index + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        FaceBook_Subset1 p = new FaceBook_Subset1();
        System.out.println(p.subsets(nums));
    }
}
