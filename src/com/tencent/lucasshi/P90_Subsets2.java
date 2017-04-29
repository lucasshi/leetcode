package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fzy on 17/4/28.
 */
public class P90_Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 有一个默认的
        Arrays.sort(nums);
        List<Integer> nullList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(nullList);

        int i = 0;
        while (i < nums.length) {
            int value = nums[i];
            int[] nums2 = new int[nums.length - 1 - i];
            int index = 0;
            // nums
            for (int j = i; j < nums.length; j++) {
                if (nums[j] != value) {
                    nums2[index] = nums[j];
                    index++;
                }
            }

            List<List<Integer>> tmpResult = subsetsWithDup(nums2);
            for (List<Integer> tmp : tmpResult) {
                tmp.add(value);
                result.add(tmp);
            }

            // nums
            for (; i < nums.length; i++) {
                if (nums[i] != value) {
                    break;
                }
            }
        }
        return result;
    }
}
