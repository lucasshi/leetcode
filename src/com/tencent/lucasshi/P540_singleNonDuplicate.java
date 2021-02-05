package com.tencent.lucasshi;


public class P540_singleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int lindex = 0;
        int rindex = nums.length;

        while (lindex < rindex) {
            int midindex = (lindex + rindex);
            if (nums[midindex - 1] == nums[midindex] && (midindex - lindex + 1) % 2 == 0) {
                lindex = midindex + 1;
            } else if (nums[midindex - 1] == nums[midindex] && (midindex - lindex + 1) % 2 == 1) {
                rindex = midindex;
            } else if (nums[midindex + 1] == nums[midindex] && (midindex - lindex + 1) % 2 == 1) {
                rindex = midindex - 1;
            } else if (nums[midindex + 1] == nums[midindex] && (midindex - lindex + 1) % 2 == 0) {
                lindex = midindex;
            } else {
                return nums[midindex];
            }
        }
        return nums[lindex];
    }
}
