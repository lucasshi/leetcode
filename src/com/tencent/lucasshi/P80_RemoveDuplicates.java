package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/29.
 */
public class P80_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int resultIndex = 0;

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        while (index < nums.length) {
            // 边界条件
            int value = nums[index];
            int count = 0;
            for (; index < nums.length; index++) {
                if (nums[index] != value) {
                    break;
                }
                count++;
            }

            if (count == 1) {
                nums[resultIndex] = value;
                resultIndex += 1;
            } else if (count >= 2) {
                nums[resultIndex] = value;
                nums[resultIndex + 1] = value;
                resultIndex += 2;
            }
        }

        return resultIndex;
    }
}
