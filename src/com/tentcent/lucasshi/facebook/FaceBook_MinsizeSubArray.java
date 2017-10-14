package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/3.
 */
public class FaceBook_MinsizeSubArray {
  public int minSubArrayLen(int target, int[] nums) {
    int startIndex = 0;
    int endIndex = 1;
    int sum = nums[0];
    int minInterval = Integer.MAX_VALUE;

    while (endIndex <= nums.length) {
      if (sum < target) {
        if (endIndex == nums.length)
          break;
        sum += nums[endIndex];
        endIndex++;
        continue;
      }
      // do
      if (sum > target) {
        sum -= nums[startIndex];
        startIndex++;
        continue;
      }

      minInterval = Math.min(endIndex - startIndex - 1, minInterval);
      for (int i = startIndex; i < endIndex; i++) {
        System.out.print(nums[i] + " ");
      }
      System.out.println();
      System.out.flush();
      sum -= nums[startIndex];
      startIndex++;
    }
    return minInterval;
  }

  public void maxLength(int target, int[] nums) {
    int startIndex = 0;
    int endIndex = 0;
    int sum = nums[startIndex];

    while (endIndex < nums.length) {
      if (sum < target) {
        endIndex++;
        if (endIndex >= nums.length)
          break;
        sum += nums[endIndex];
      } else if (sum > target) {
        sum -= nums[startIndex];
        startIndex++;
      } else {
        System.out.println(endIndex + " " + startIndex);
        for (int i = startIndex; i <= endIndex; i++)
          System.out.print(nums[i] + " ");
        System.out.println();
        sum -= nums[startIndex];
        startIndex++;
      }
    }
  }

  public static void main(String[] args) {
    FaceBook_MinsizeSubArray p = new FaceBook_MinsizeSubArray();
    int[] a = {2, 3, 1, 2, 4, 3};
    //p.minSubArrayLen(7, a);
    p.maxLength(1, a);
  }
}
