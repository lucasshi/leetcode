package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by fzy on 17/9/16.
 */
public class P325_MaxSumArrayLength {
    private HashMap<Integer, Integer> totalSums = new HashMap<>();

    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int[] sums = new int[nums.length];
        // build index
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!totalSums.containsKey(sum)) {
                totalSums.put(sum, i);
            }
            sums[i] = sum;
        }

        // other
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = sums[i];
            int target = currentSum - k;
            // 从开始到现在的
            if (target == 0) {
                maxSize = Math.max(maxSize, i + 1);
                continue;
            }

            if (!totalSums.containsKey(target)) {
                continue;
            } else {
                int targetIndex = totalSums.get(target);
                // 如果小于i
                if (targetIndex < i) {
                    maxSize = Math.max(maxSize, i - targetIndex);
                }
            }
        }

        return maxSize;
    }
}
