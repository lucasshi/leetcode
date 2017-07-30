package com.tencent.lucasshi;

import java.util.TreeMap;

/**
 * Created by fzy on 17/7/30.
 */
public class P220_containsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Integer, Integer> posMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 删除K
            int deleteIndex = i - k - 1;
            if (deleteIndex >= 0) {
                int deleteNum = nums[deleteIndex];
                if (posMap.containsKey(deleteNum) && posMap.get(deleteNum) == deleteIndex) {
                    posMap.remove(deleteNum);
                }
            }

            // 进行查询
            if (posMap.ceilingKey(nums[i]) != null) {
                int ceiling = posMap.ceilingKey(nums[i]);
                if (Math.abs(ceiling - nums[i]) <= t)
                    return true;
            }

            if (posMap.floorKey(nums[i]) != null) {
                long floor = posMap.floorKey(nums[i]);
                if (Math.abs(floor - nums[i]) <= t)
                    return true;
            }


            posMap.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        P220_containsDuplicate3 p = new P220_containsDuplicate3();
        int[] a = {-1, 2147483647};
        System.out.println(p.containsNearbyAlmostDuplicate(a, 1, 2147483647));

    }
}
