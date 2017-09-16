package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/13.
 */
public class P268_MissingNumber {
    public int missingNumber(int[] nums) {
        int size = nums.length + 1;
        int expectSum = (size - 1) * size / 2;
        int actualSum = 0;

        for (int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
        }

        return expectSum - actualSum;
    }
}
