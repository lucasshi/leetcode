package com.tencent.lucasshi;

import java.util.*;

/**
 * Created by fzy on 17/5/10.
 */
public class P164_MaxiumGap {
    public int maximumGap(int[] nums) {
        TreeMap<Integer, TreeSet<Integer>> bucketMap = new TreeMap<>();

        // do [分成1000个痛]
        for (int i = 0; i < nums.length; i++) {
            int bucketId = nums[i] / 1000;
            if (bucketMap.containsKey(bucketId)) {
                TreeSet<Integer> treeSet = bucketMap.get(bucketId);
                if (!treeSet.contains(nums[i])) {
                    treeSet.add(nums[i]);
                }
            } else {
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(nums[i]);
                bucketMap.put(bucketId, treeSet);
            }
        }

        // buildIndex之后开始
        int maxGap = 0;
        int betweenBucketGap = -1;
        int bucketMax = -1; // 上一个最大值
        for (Map.Entry<Integer, TreeSet<Integer>> entry : bucketMap.entrySet()) {
            int inBucketGap = -1;
            int lastVal = -1;
            for (Integer val : entry.getValue()) {
                if (lastVal == -1) {
                    lastVal = val;
                    if (bucketMax != -1) {
                        betweenBucketGap = val - bucketMax; // 第一个所以其实就是上一个的最后一个
                    }
                } else {
                    inBucketGap = Math.max(val - lastVal, inBucketGap);
                    lastVal = val;
                }
            }

            bucketMax = lastVal;
            int roundMaxGap = Math.max(inBucketGap, betweenBucketGap);
            maxGap = Math.max(roundMaxGap, maxGap);
        }

        return maxGap;
    }

    public static void main(String[] args) {
        P164_MaxiumGap p = new P164_MaxiumGap();
        int[] nums = {1, 10000000};
        p.maximumGap(nums);
    }
}
