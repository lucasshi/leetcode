package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by fzy on 17/9/9.
 */
public class P239_SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        P239_SlidingWindowMax p239 = new P239_SlidingWindowMax();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        //int[] nums = {7, 2, 4};

        p239.maxSlidingWindow(nums, 3);
    }
}
