package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/14.
 */
public class FaceBook_SubArrayLargestSmallThan {
    public int getSum(int[] nums, int k) {
        int start = 0;
        int end = -1;
        int count = 0;

        for (start = 0; start < nums.length; start++) {
            int key = nums[start];
            int left = start;
            int right = nums.length - 1;

            if (key * 2 > k) {
                break;
            }

            end = -1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] + key > k) {
                    right = mid - 1;
                } else if (nums[mid] + key < k) {
                    if (mid == nums.length - 1 || nums[mid + 1] + key > k) {
                        end = mid;
                        break;
                    }
                    right = mid + 1;
                }
            }

            if (end == start) {
                count += 1;
            } else {
                count += Math.pow(2, end - start);
            }
        }

        return count;
    }
}
