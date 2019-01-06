package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_SubSet2 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> subs = new ArrayList<>();
        helper(subs, nums, 0);
        return result;
    }

    public void helper(List<Integer> subs, int[] nums, int index) {
        if (index == nums.length)
            return;

        // other
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;
            subs.add(nums[i]);
            result.add(new ArrayList<>(subs));
            helper(subs, nums, i + 1);
            subs.remove(subs.size() - 1);
        }
    }

    public static void main(String[] args) {
        FaceBook_SubSet2 p = new FaceBook_SubSet2();
        int[] input = {1, 2, 2};
        System.out.println(p.subsetsWithDup(input));
    }


}
