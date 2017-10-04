package com.tentcent.lucasshi.facebook;

import java.util.HashMap;

/**
 * Created by fzy on 17/10/3.
 */
public class FaceBook_LongestConsequnce {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> exists = new HashMap<>();
        boolean[] visited = new boolean[nums.length];

        // put
        for (int i = 0; i < nums.length; i++) {
            exists.put(nums[i], i);
        }

        int maxSeq = -1;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;

            int seqLength = 1;
            visited[i] = true;
            for (int j = 1; ; j++) {
                if (exists.containsKey(nums[i] + j)) {
                    int index = exists.get(nums[i] + j);
                    visited[index] = true;
                    seqLength++;
                } else {
                    break;
                }
            }

            // 往下看
            for (int j = -1; ; j--) {
                if (exists.containsKey(nums[i] + j)) {
                    int index = exists.get(nums[i] + j);
                    visited[index] = true;
                    seqLength++;
                } else {
                    break;
                }
            }

            maxSeq = Math.max(maxSeq, seqLength);
        }

        return maxSeq;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        FaceBook_LongestConsequnce p = new FaceBook_LongestConsequnce();
        System.out.println(p.longestConsecutive(nums));
    }
}
