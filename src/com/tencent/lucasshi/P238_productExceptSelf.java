package com.tencent.lucasshi;

public class P238_productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] forwardProduct = new int[nums.length];
        int[] backwardProduct = new int[nums.length];
        int[] result = new int[nums.length];

        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            forwardProduct[i] = product;
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            backwardProduct[i] = product;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = backwardProduct[i + 1];
            } else if (i == nums.length - 1) {
                result[i] = forwardProduct[i - 1];
            } else {
                result[i] = forwardProduct[i - 1] * backwardProduct[i + 1];
            }
        }

        return result;
    }
}
