package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fzy on 17/10/15.
 */
public class FaceBook_leeterCombination {
    public static HashMap<Integer, String>
            map = new HashMap<Integer, String>();
    private List<String> result = new ArrayList<>();

    static {
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public List<String> leeterCombination(int[] nums) {
        String output = "";
        helper(output, nums, 0);
        return result;
    }

    public void helper(String output, int[] nums, int index) {
        if (index == nums.length) {
            result.add(output);
            return;
        }

        String subs = map.get(nums[index]);
        for (int i = 0; i < subs.length(); i++) {
            output = output + subs.charAt(i);
            helper(output, nums, index + 1);
            output = output.substring(0, output.length() - 1);
        }

        return;
    }

    public static void main(String[] args) {
        FaceBook_leeterCombination p = new FaceBook_leeterCombination();
        int[] nums = {7, 3};
        System.out.println(p.leeterCombination(nums));
    }
}
