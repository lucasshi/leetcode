package com.tentcent.lucasshi.facebook;

import java.util.Arrays;

/**
 * Created by fzy on 17/10/3.
 */
public class Facebook_NextPermutation {
    public void nextPermutation(int[] nums) {
        int swapIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[i - 1]) {
                swapIndex = i - 1;
                break;
            }
        }

        if (swapIndex == -1)
            Arrays.sort(nums);

        int[] swapBuffer = new int[nums.length - swapIndex - 1];
        for (int i = 0; i < swapBuffer.length; i++) {
            swapBuffer[i] = nums[i + swapIndex + 1];
        }

        Arrays.sort(swapBuffer);
        for (int i = 0; i < swapBuffer.length; i++) {
            if (swapBuffer[i] > nums[swapIndex]) {
                int tmp = nums[swapIndex];
                nums[swapIndex] = swapBuffer[i];
                swapBuffer[i] = tmp;
                break;
            }
        }

        for (int i = 0; i < swapBuffer.length; i++) {
            nums[i + swapIndex + 1] = swapBuffer[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 9, 7, 5, 4, 3, 2, 1};
        Facebook_NextPermutation p = new Facebook_NextPermutation();
        p.nextPermutation(a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
