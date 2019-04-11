package com.tencent.lucasshi;


import lintcode.P1639_kSubstringKCharacter;

import java.util.ArrayList;
import java.util.List;

public class P163_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int key = lower;

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != key) {
                int start = key;
                int end = nums[i] - 1;
                if (start == end)
                    result.add(key + "");
                else
                    result.add(start + "->" + end);
                key = nums[i] + 1;
            } else {
                key = nums[i] + 1;
            }
        }
        if (key != upper + 1) {
            if (key == upper)
                result.add(key + "");
            else
                result.add(key + "->" + upper);
        }
        return result;
    }

    public static void main(String[] args) {
        P163_MissingRanges p = new P163_MissingRanges();
        int[] input = {0, 1, 3, 50, 75};
        System.out.println(p.findMissingRanges(input, 0, 99));
    }
}
