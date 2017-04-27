package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/4/25.
 */
public class P78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        // 有一个默认的
        List<Integer> nullList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(nullList);

        for (int i = 0; i < nums.length; i++) {
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

            List<List<Integer>> tmpResult = subsets(nums2);
            for (List<Integer> tmp : tmpResult) {
                tmp.add(value);
                result.add(tmp);
            }
        }

        return result;
    }
}
