package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/23.
 */
public class P55_JumpGame {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxJump >= i) {
                int jump = i + nums[i];
                maxJump = Math.max(jump, maxJump);
            }
        }

        return maxJump >= nums.length - 1;
    }
}
