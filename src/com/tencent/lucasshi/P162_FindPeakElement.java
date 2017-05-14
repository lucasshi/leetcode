package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/14.
 */
public class P162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            if (startIndex == endIndex) {
                return startIndex;
            }

            int midIndex = (startIndex + endIndex) / 2;
            if (nums[midIndex] < nums[midIndex + 1])
                startIndex = midIndex + 1;
            else
                endIndex = midIndex;

        }

        return -1;
    }
}
