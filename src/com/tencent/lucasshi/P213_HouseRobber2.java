package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/14.
 */
public class P213_HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        if (nums.length == 0)
            return 0;

        int[] dpFirst = new int[nums.length];
        int[] dpNoFirst = new int[nums.length];
        //
        dpFirst[0] = nums[0];
        dpFirst[1] = nums[1];
        dpNoFirst[0] = 0;
        dpNoFirst[1] = nums[1];

        if (nums.length == 2) {
            return Math.max(dpFirst[0], dpFirst[1]);
        }

        // dp
        for (int i = 2; i < nums.length; i++) {
            if (i - 3 >= 0) {
                dpFirst[i] = Math.max(dpFirst[i - 2], dpFirst[i - 3]) + nums[i];
                dpNoFirst[i] = Math.max(dpNoFirst[i - 2], dpNoFirst[i - 3]) + nums[i];
            } else {
                dpFirst[i] = dpFirst[i - 2] + nums[i];
                dpNoFirst[i] = dpNoFirst[i - 2] + nums[i];
            }
        }

        int lastIndex = nums.length - 1;
        return Math.max(dpNoFirst[lastIndex],
                Math.max(dpNoFirst[lastIndex - 1], Math.max(dpFirst[lastIndex - 2], dpFirst[lastIndex - 1])));

    }
}
