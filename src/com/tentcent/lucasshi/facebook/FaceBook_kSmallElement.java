package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_kSmallElement {
  public int kSmallElement(int[] nums, int k) {
    int start = 0;
    int end = nums.length - 1;
    int target = k;

    while (true) {
      int count = oneRound(start, end, nums);
      if (count == target) {
        return nums[start];
      } else if (count > k) {
        end = count;
      } else {
        start = count + 1;
        target = k - count;
      }
    }
  }

  public int oneRound(int start, int end, int[] nums) {
    int pivot = nums[start];

    int left = start + 1;
    int right = end;

    while (left < right) {
      while (nums[left] < pivot)
        left++;
      while (nums[right] >= pivot)
        right--;
      if (left < right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
      }
    }

    // swap left and pivot
    int tmp = nums[left];
    nums[left] = nums[start];
    nums[start] = tmp;

    return (left - start - 1);
  }
}
