package com.tencent.lucasshi;

import java.util.Arrays;

public class P1509_minDifference {
    public int minDifference(int[] nums) {
        if (nums.length < 4)
            return 0;

        int[] sorted = Arrays.stream(nums).sorted().toArray();

        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            int small = sorted[i];
            int larget = sorted[nums.length - 1 - (3 - i)];
            diff = Math.min(diff, larget - small);
        }

        return diff;
    }

    public static void main(String[] args) {
        int[] test = {1,5,0,10,1};
        P1509_minDifference p1509_minDifference = new P1509_minDifference();
        p1509_minDifference.minDifference(test);
    }
}
