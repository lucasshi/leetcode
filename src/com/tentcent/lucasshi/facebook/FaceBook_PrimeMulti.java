package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/10/14.
 */
public class FaceBook_PrimeMulti {
    public List<Integer> getPrimMutli(int[] nums) {
        List<Integer> result = new ArrayList<>();
        helper(result, nums, 0);
        return result;
    }

    public void helper(List<Integer> res, int[] nums, int start) {
        if (start == nums.length - 1) {
            res.add(nums[start]);
            return;
        }

        helper(res, nums, start + 1);
        int size = res.size();
        if (nums[start] != 1) {
            for (int i = 0; i < size; i++) {
                res.add(res.get(i) * nums[start]);
            }
        }
        res.add(nums[start]);
    }

    public static void main(String[] args) {
        FaceBook_PrimeMulti p = new FaceBook_PrimeMulti();
        int[] nums = {1, 2, 3, 5};
        System.out.println(p.getPrimMutli(nums));
    }


}
