package com.tentcent.lucasshi.facebook;

import java.util.Random;

/**
 * Created by fzy on 17/10/3.
 */
public class FaceBook_PickNumber {
    private int[] nums;

    public int pick(int target) {
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                count++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int rand = random.nextInt(count);
                if (rand == 1) {
                    return i;
                }
                count--;
            }
        }

        return -1;
    }
}
