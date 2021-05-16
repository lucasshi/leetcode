package com.tencent.lucasshi;

public class P189_rotate {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        swap(0, nums.length - 1, nums);
        swap(0, k - 1, nums);
        swap(k, nums.length - 1, nums);
    }

    void swap(int start, int end, int[] nums) {
        int s = start;
        int e = end;

        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}
