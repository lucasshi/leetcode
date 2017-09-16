package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/16.
 */
public class P283_MoveZeros {
    public void moveZeroes(int[] nums) {
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[startIndex] = nums[i];
                startIndex++;
            }
        }

        for (int i = startIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

