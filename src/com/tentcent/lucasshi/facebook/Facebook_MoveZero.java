package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/2.
 */
public class Facebook_MoveZero {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (true) {
            while (nums[i] != 0) {
                i++;
            }

            while (nums[j] == 0) {
                j--;
            }

            if (i >= j)
                break;

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        for (i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void MoveZeroV2(int[] nums) {
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[startIndex] = nums[i];
                startIndex++;
            }
        }

        for (int i = startIndex; i < nums.length; i++)
            nums[i] = 0;
    }

    public static void main(String[] args) {
        Facebook_MoveZero p = new Facebook_MoveZero();
        int[] nums = {0, 1, 0, 3, 12};
        p.moveZeroes(nums);
    }
}
