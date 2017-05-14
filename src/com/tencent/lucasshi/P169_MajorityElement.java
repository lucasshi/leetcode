package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/14.
 */
public class P169_MajorityElement {
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 1;

        if (nums.length == 1) {
            return element;
        }

        // do
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == element) {
                count++;
                continue;
            }

            if (count == 0) {
                element = nums[i];
                count++;
            } else {
                count--;
            }
        }

        return element;
    }
}
