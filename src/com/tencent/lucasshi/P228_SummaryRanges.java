package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/7/31.
 */
public class P228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();

        if (nums.length == 1) {
            List<String> results = new ArrayList<>();
            results.add(nums[0] + "");
            return results;
        }


        List<String> results = new ArrayList<>();
        int start = nums[0];
        int end = start;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[0] <= 1) {
                continue;
            }

            end = nums[i - 1];
            if (start != end) {
                results.add(start + "->" + end);
            } else {
                results.add(start + "");
            }

            start = nums[i];
        }

        if (start != end) {
            results.add(start + "->" + end);
        } else {
            results.add(start + "");
        }
        return results;
    }
}
