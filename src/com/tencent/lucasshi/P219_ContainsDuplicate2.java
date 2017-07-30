package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 17/7/30.
 */
public class P219_ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (posMap.containsKey(nums[i])) {
                if (i - posMap.get(nums[i]) <= k) {
                    return true;
                }
            }
            posMap.put(nums[i], i);
        }

        return false;
    }
}
