package com.tencent.lucasshi;

import java.util.HashSet;

/**
 * Created by fzy on 17/7/30.
 */
public class P217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> dupmap = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (dupmap.contains(nums[i])){
                return true;
            }
            dupmap.add(nums[i]);
        }

        return false;
    }
}
