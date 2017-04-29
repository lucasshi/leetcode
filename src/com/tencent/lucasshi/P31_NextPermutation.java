package com.tencent.lucasshi;

import java.util.Arrays;

/**
 * Created by fzy on 17/4/29.
 */
public class P31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int swapIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                swapIndex = i - 1;
                break;
            }
        }

        // 没找到
        if (swapIndex == -1) {
            Arrays.sort(nums);
            return;
        }

        // 重新计算
        int[] swapNum = new int[nums.length - swapIndex - 1];
        for (int i = swapIndex + 1; i < nums.length; i++) {
            swapNum[i - swapIndex - 1] = nums[i];
        }

        // 进行排序
        Arrays.sort(swapNum);
        for (int i = 0; i < swapNum.length; i++) {
            if (swapNum[i] > nums[swapIndex]) {
                int tmp = swapNum[i];
                swapNum[i] = nums[swapIndex];
                nums[swapIndex] = tmp;
                break;
            }
        }

        for (int i = 0; i < swapNum.length; i++) {
            nums[swapIndex + i + 1] = swapNum[i];
        }
    }
}
