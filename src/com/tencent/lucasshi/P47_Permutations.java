package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fzy on 17/4/29.
 */
public class P47_Permutations {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        MyPermute(nums, 0, nums.length - 1, result);
        return result;
    }

    public void MyPermute(int[] nums, int startIndex, int endIndex, List<List<Integer>> result) {
        if (startIndex == endIndex) {
            List<Integer> permuteList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                permuteList.add(nums[i]);
            }
            result.add(permuteList);
        }

        //
        int pivot = nums[startIndex];
        for (int index = startIndex; index < endIndex; index++) {
            if (nums[index] == pivot && index != startIndex) {
                continue;
            }
            int tmp = nums[index];
            nums[index] = nums[startIndex];
            nums[startIndex] = tmp;
            // 进行运算
            MyPermute(nums, startIndex + 1, endIndex, result);
            // 然后交换回来
            tmp = nums[index];
            nums[index] = nums[startIndex];
            nums[startIndex] = tmp;
        }
    }
}
