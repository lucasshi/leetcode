package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/4.
 */
public class P136_SingleNumber {
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }

        return nums[0];
    }
}
