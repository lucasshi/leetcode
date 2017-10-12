package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/10.
 */
public class FaceBook_RotateMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = nums[(right + left) / 2];
            int start = nums[left];
            int end = nums[right];

            if (mid < end) {
                right = (right + left) / 2;
            } else {
                left = (right + left) / 2 + 1;
            }
        }

        return nums[left];
    }
}
