package com.tentcent.lucasshi.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by fzy on 17/10/14.
 */
public class FaceBook_TopK {
    public List<Integer> topK(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(pq);
        return result;
    }

    public static void main(String[] args) {

    }
}
