package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by fzy on 17/10/13.
 */
public class FaceBook_AllPermutation {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int n) {
        List<Integer> nums = Arrays.asList(1, 2, 2);
        helper2(nums, 0);
        System.out.println(result);
        return result;
    }

    // 去重版本
    public void helper2(List<Integer> nums, int start) {
        if (start == nums.size() - 1) {
            ArrayList<Integer> subResult = new ArrayList<>();
            subResult.addAll(nums);
            result.add(subResult);
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            if (i != start && nums.get(i) == nums.get(i - 1)) {
                continue;
            }
            int temp = nums.get(i);
            nums.set(i, nums.get(start));
            nums.set(start, temp);
            // do
            helper2(nums, start + 1);
            // swap back
            temp = nums.get(i);
            nums.set(i, nums.get(start));
            nums.set(start, temp);
        }
    }

    public void helper(List<Integer> nums, int start) {
        if (start == nums.size() - 1) {
            ArrayList<Integer> subResult = new ArrayList<>();
            subResult.addAll(nums);
            result.add(subResult);
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            int temp = nums.get(i);
            nums.set(i, nums.get(start));
            nums.set(start, temp);
            // do
            helper(nums, start + 1);
            // swap back
            temp = nums.get(i);
            nums.set(i, nums.get(start));
            nums.set(start, temp);
        }
    }

    public static void main(String[] args) {
        FaceBook_AllPermutation p = new FaceBook_AllPermutation();
        p.permute(4);
    }


}
