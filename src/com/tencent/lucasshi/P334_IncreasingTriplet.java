package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/17.
 */
public class P334_IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > minTwo)
                return true;

            if (nums[i] <= minOne) {
                minOne = nums[i];
                continue;
            }

            if (nums[i] <= minTwo) {
                minTwo = nums[i];
                continue;
            }
        }

        return false;
    }
}
