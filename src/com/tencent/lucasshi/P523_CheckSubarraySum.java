package com.tencent.lucasshi;

import java.util.HashSet;

public class P523_CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length];
        int sum = 0;
        k = Math.abs(k);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }

        HashSet<Integer> sets = new HashSet<>();
        for (int i = 0; i < sums.length; i++) {
            int newk = k;
            while (newk < sums[i]) {
                if (i > 0 && sums[i] == newk) {
                    return true;
                }
                if (sets.contains(sums[i] - newk)) {
                    return true;
                }
                if (k == 0) {
                    break;
                }
                newk += k;
            }
            if (i > 0) {
                sets.add(sums[i - 1]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P523_CheckSubarraySum p = new P523_CheckSubarraySum();
        int[] array = {23, 2, 4, 6, 7};
        p.checkSubarraySum(array, 6);
    }
}
