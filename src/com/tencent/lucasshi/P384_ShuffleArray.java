package com.tencent.lucasshi;

import java.util.Random;

/**
 * Created by fzy on 17/10/1.
 */

public class P384_ShuffleArray {
    private int[] nums;
    private int[] shuffledNums;

    private Random random = new Random();

    public P384_ShuffleArray(int[] nums) {
        this.nums = nums;
        this.shuffledNums = new int[nums.length];

        for (int i = 0; i < shuffledNums.length; i++)
            shuffledNums[i] = nums[i];

        this.random = random;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        // rand
        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(nums.length - i);
            int temp = shuffledNums[index];
            shuffledNums[index] = shuffledNums[nums.length - 1 - i];
            shuffledNums[nums.length - 1 - i] = temp;
        }

        return shuffledNums;
    }
}
