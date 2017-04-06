package com.tencent.lucasshi;

/**
 * Created by fzy on 17/3/31.
 */
public class P41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // 进行处理
        int index = 0;
        while (index < nums.length) {
            if (nums[index] <= 0) {
                index++;
            }
            // 如果不符合直接swap
            if (nums[index] != index) {
                int swapIndex = nums[index] - 1;
                if (swapIndex > nums.length - 1) {
                    index++;
                    continue;
                }

                int tmp = nums[index];
                nums[index] = nums[swapIndex];
                nums[swapIndex] = tmp;
            } else {
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i;
            }
        }

        return nums.length;
    }
}
