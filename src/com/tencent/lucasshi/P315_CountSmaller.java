package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P315_CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        Stack<Integer> stacks = new Stack<>();
        Integer[] result = new Integer[nums.length];
        // List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i > 0; i--) {
            if (!stacks.empty() || stacks.peek() < nums[i])
                stacks.pop();
            result[result.length - 1 - i] = stacks.size();
            stacks.push(nums[i]);
        }

        return  Arrays.asList(result);
        //return new ArrayList<Integer>(result);
    }
}
