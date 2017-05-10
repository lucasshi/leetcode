package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/6.
 */
public class P154_FindMinimum2 {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
        }
        return min;
    }
}
