package com.tencent.lucasshi;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by fzy on 17/9/17.
 */
public class P414_ThirdMaxNumber {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!pq.contains(nums[i])) {
                pq.offer(nums[i]);
            }
            if (pq.size() > 3) {
                pq.poll();
            }
            max = Math.max(max, nums[i]);
        }

        if (pq.size() < 3) {
            return max;
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.offer(10);

        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(1);
        set.add(2);
        set.add(4);

        for (Integer val : set) {
            System.out.println(val);
        }
    }
}
