package com.tencent.lucasshi;

import java.util.HashMap;

public class P560_subarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> cnts = new HashMap<>();
        int count = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count += 1;
            }

            // add
            int diff = sum - k;

            count += cnts.getOrDefault(diff, 0);
            cnts.putIfAbsent(sum, 0);
            cnts.put(sum, cnts.get(sum) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 4, 23};
        int k = 8;

        P560_subarraySum p560_subarraySum = new P560_subarraySum();
        p560_subarraySum.subarraySum(nums, 8);
    }
}
