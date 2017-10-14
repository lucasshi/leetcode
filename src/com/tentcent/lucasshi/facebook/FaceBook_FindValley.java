package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/13.
 */
public class FaceBook_FindValley {
    public int findValley(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid + 1] > nums[mid] && nums[mid - 1] > nums[mid])
                return nums[mid];

            if (nums[mid + 1] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        FaceBook_FindValley p = new FaceBook_FindValley();
        int[] nums = {6, 5, 4, 3, 2, 3, 4};
        System.out.println(p.findValley(nums));
    }
}
