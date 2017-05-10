package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/6.
 */
public class P152_MaxiumProductArray {
    public int maxProduct(int[] nums) {
        int[] maxProduct = new int[nums.length];
        int[] minProduct = new int[nums.length];

        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];

        //
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxProduct[i] = 0;
                minProduct[i] = 0;
                continue;
            }

            if (nums[i] < 0) {
                maxProduct[i] = Math.max(nums[i], minProduct[i - 1] * nums[i]);
                minProduct[i] = Math.min(nums[i], maxProduct[i - 1] * nums[i]);
                continue;
            }

            if (nums[i] > 0) {
                maxProduct[i] = Math.max(nums[i], maxProduct[i - 1] * nums[i]);
                minProduct[i] = Math.min(nums[i], minProduct[i - 1] * nums[i]);
                continue;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, maxProduct[i]);
        }
        return max;
    }
}
