package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fzy on 17/4/6.
 */
public class P46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, nums.length - 1, result);
        return result;
    }

    public void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    public void helper(int[] nums, int start, int end, List<List<Integer>> result) {
        if (start == end) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = start; i <= end; i++) {
            swap(nums, start, i);
            helper(nums, start + 1, end, result);
            swap(nums, start, i);
        }
    }

    public static void main(String[] args) {
        P46_Permutations p46_permutations = new P46_Permutations();
        System.out.println(p46_permutations.permute(new int[]{1, 2, 3}));
    }

}
