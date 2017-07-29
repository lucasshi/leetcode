package com.tencent.lucasshi;

/**
 * Created by fzy on 17/7/29.
 */
public class P215_FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int L = 0, R = nums.length - 1;
        while (L < R) {
            int left = L, right = R;
            int key = nums[left];
            while (left < right) {
                while (left < right && nums[right] < key) --right;
                nums[left] = nums[right];
                while (left < right && nums[left] >= key) ++left;
                nums[right] = nums[left];
            }
            nums[left] = key;
            if (left == k - 1) return nums[k - 1];
            else if (left > k - 1) R = left - 1;
            else L = left + 1;
        }
        return nums[k - 1];
    }

    public static void main(String[] args) {

    }
}
