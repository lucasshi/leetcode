package com.tencent.lucasshi;

import java.util.Random;

/**
 * Created by fzy on 17/10/1.
 */

public class P384_ShuffleArray {
    private int[] nums;
    private Random random = new Random();

    public P384_ShuffleArray(int[] nums) {
        this.nums = nums;
        this.random = random;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] randNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            randNums[i] = nums[i];
        // rand
        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(nums.length - i);
            int temp = randNums[index];
            randNums[index] = randNums[nums.length - 1 - i];
            randNums[nums.length - 1 - i] = temp;
        }

        return randNums;
    }

}
