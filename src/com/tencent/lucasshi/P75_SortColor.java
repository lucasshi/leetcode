package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/25.
 */
public class P75_SortColor {
    public void sortColors(int[] nums) {
        int oneNumber = 0;
        int zeroNumber = 0;
        int twoNumber = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                oneNumber++;
            } else if (nums[i] == 2) {
                twoNumber++;
            } else {
                zeroNumber++;
            }
        }

        int index = 0;
        for (int i = 0; i < zeroNumber; i++) {
            nums[index] = 0;
            index++;
        }

        for (int i = 0; i < oneNumber; i++) {
            nums[index] = 1;
            index++;
        }

        for (int i = 0; i < twoNumber; i++) {
            nums[index] = 2;
            index++;
        }

        return;
    }
}
