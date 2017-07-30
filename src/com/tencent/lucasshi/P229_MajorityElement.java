package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/7/30.
 */
public class P229_MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        int number1 = -12391239, number2 = -231389;
        int count1 = 0, count2 = 0;

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != number2) {
                number1 = nums[i];
                count1++;
                continue;
            }

            if (count2 == 0 && nums[i] != number1) {
                number2 = nums[i];
                count2++;
                continue;
            }

            if (nums[i] == number1) {
                count1++;
                continue;
            }

            if (nums[i] == number2) {
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

        int newCount1 = 0;
        int newCount2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1 && count1 > 0)
                newCount1++;
            if (nums[i] == number2 && count2 > 0)
                newCount2++;
        }

        if (newCount1 >= nums.length / 3.0) {
            result.add(number1);
        }

        if (newCount2 >= nums.length / 3.0) {
            result.add(number2);
        }
        return result;
    }

    public static void main(String[] args) {
        P229_MajorityElement p = new P229_MajorityElement();
        int[] nums = {-1, 1, 1, 1, 2, 1};
        p.majorityElement(nums);
    }
}
