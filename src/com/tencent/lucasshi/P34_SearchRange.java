package com.tencent.lucasshi;

/**
 * Created by fzy on 17/3/29.
 */
public class P34_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int index = -1;
        int[] result = new int[2];

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                index = mid;
                break;
            }
        }

        if (index == -1) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        // range的查询
        result[0] = index;
        result[1] = index;

        int startIndex = index - 1;
        int endIndex = index + 1;
        while (startIndex >= 0 && nums[startIndex] == target) {
            startIndex--;
            result[0]--;
        }

        while (endIndex < nums.length && nums[endIndex] == target) {
            endIndex++;
            result[1]++;
        }

        return result;
    }

}
