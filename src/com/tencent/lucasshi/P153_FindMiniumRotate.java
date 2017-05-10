package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/6.
 */
public class P153_FindMiniumRotate {
    public int findMin(int[] nums) {
        int length = nums.length;
        int startIndex = 0;
        int endIndex = length - 1;

        while (startIndex < endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            if (nums[midIndex] < nums[endIndex]) {
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }

        return nums[startIndex];
    }
}
