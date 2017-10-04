package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/3.
 */
public class FaceBook_SearchRotate {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int k = (i + j) / 2;
            int mid = nums[k];
            int start = nums[i];
            int end = nums[j];

            // 左边
            if (target == mid)
                return (i + j) / 2;

            if (start < mid) {
                if (target < mid && target >= start) {
                    j = k - 1;
                } else {
                    i = k + 1;
                }
            } else {
                if (target > mid && target <= end) {
                    i = k + 1;
                } else {
                    j = k - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FaceBook_SearchRotate p = new FaceBook_SearchRotate();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(p.search(nums, 9));
    }
}
