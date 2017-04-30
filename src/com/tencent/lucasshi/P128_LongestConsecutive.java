package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 17/4/30.
 */
public class P128_LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> dpMap = new HashMap<>();
        HashMap<Integer, Boolean> existMap = new HashMap<>();

        // existMap
        for (int i = 0; i < nums.length; i++) {
            existMap.put(nums[i], true);
        }

        int maxSeq = 0;
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            int k = 0;
            while (true) {
                if (!existMap.containsKey(k + element)) {
                    break;
                }

                // 已经处理了
                if (dpMap.containsKey(k + element)) {
                    k = k + dpMap.get(k + element);
                    break;
                }

                k++;
            }

            // 设置结果
            for (int j = 0; j < k; j++) {
                if (!dpMap.containsKey(element + j)) {
                    dpMap.put(element + j, k - j);
                    maxSeq = Math.max(maxSeq, k - j);
                } else {
                    break;
                }
            }
        }

        return maxSeq;
    }

    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(a));
    }
}
