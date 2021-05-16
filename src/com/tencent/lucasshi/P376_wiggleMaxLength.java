package com.tencent.lucasshi;

public class P376_wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int curDiff = 0;
        int preDiff = 0;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (preDiff >= 0 && curDiff < 0)) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }
}
