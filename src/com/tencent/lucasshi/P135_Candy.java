package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/4.
 */
public class P135_Candy {
    int candy(int[] ratings) {
        int size = ratings.length;
        if (size <= 1) return ratings.length;
        int[] nums = new int[ratings.length];
        // left->right
        for (int i = 1; i < size; i++) {
            if (ratings[i] > ratings[i - 1])
                nums[i] = nums[i - 1] + 1;
        }
        // right->left
        for (int i = size - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i])
                nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
        }

        int result = 0;
        for (int i = 0; i < size; i++)
            result += nums[i];
        return result;
    }
}
