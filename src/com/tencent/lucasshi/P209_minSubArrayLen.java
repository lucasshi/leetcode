package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/28.
 */
public class P209_minSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int startIndex = 0;
        int endIndex = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        boolean find = false;

        for (; endIndex < nums.length; endIndex++) {
            sum += nums[endIndex];
            if (sum < s) {
                continue;
            } else if (sum > s) {
                while (startIndex < endIndex) {
                    sum = sum - nums[startIndex];
                    if (sum >= s) {
                        startIndex++;
                    } else {
                        break;
                    }
                }

                sum = sum + nums[startIndex];
                result = Math.min(endIndex - startIndex + 1, result);
                find = true;
            }
        }

        return find ? result : 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;

        P209_minSubArrayLen p = new P209_minSubArrayLen();
        p.minSubArrayLen(s, nums);
    }
}
