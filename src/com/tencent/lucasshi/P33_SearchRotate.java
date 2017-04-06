package com.tencent.lucasshi;

/**
 * Created by fzy on 17/3/29.
 */
public class P33_SearchRotate {
    public int search(int[] nums, int target) {
        int midIndex = (nums.length - 1) / 2;
        int endIndex= nums.length - 1;
        int startIndex = 0;

        while (startIndex < endIndex) {
            // 起点在中点之后
            if (nums[midIndex] > nums[endIndex]) {
                // 说明在右边
                if (target > nums[midIndex] || target < nums[endIndex]) {
                    startIndex = midIndex + 1;
                    midIndex = (startIndex + endIndex) / 2;
                }

                // 说明在左边
                if (target < nums[midIndex] && target > nums[startIndex]) {
                    endIndex = midIndex - 1;
                    midIndex = (startIndex + endIndex) / 2;
                }
            }

            // 起点在中点之前
            if (nums[midIndex] < nums[endIndex]) {
                if (target < nums[midIndex] || target > nums[startIndex]) {
                    endIndex = midIndex - 1;
                    midIndex = (startIndex + endIndex) / 2;
                }


                if (target > nums[midIndex] && target < nums[endIndex]) {
                    startIndex = midIndex + 1;
                    midIndex = (startIndex + endIndex) / 2;
                }
            }

            if (nums[midIndex] == target) {
                return midIndex;
            }
        }

        return -1;
    }
}
