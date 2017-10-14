package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/13.
 */
public class FaceBook_FindOne {
    public int FindOne(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == 0) {
                left = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] == 0) {
                    return mid;
                }
                right = mid - 1;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        FaceBook_FindOne p = new FaceBook_FindOne();
        System.out.println(p.FindOne(nums));
    }
}
