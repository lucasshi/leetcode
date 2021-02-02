package com.tencent.lucasshi;

import java.util.Arrays;

public class P977_sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int minIndex = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs < minAbs) {
                minIndex = i;
                minAbs = abs;
            }
        }

        int left = minIndex - 1;
        int right = minIndex;
        int index = 0;

        while (index < nums.length) {

            if (left < 0) {
                result[index] = nums[right] * nums[right];
                right++;
                index++;
            } else if (right > nums.length - 1) {
                result[index] = nums[left] * nums[left];
                left--;
                index++;
            } else if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[right] * nums[right];
                right++;
                index++;
            } else {
                result[index] = nums[left] * nums[left];
                left--;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        P977_sortedSquares p977_sortedSquares = new P977_sortedSquares();
        p977_sortedSquares.sortedSquares(nums);
    }
}
