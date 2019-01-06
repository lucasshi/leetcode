package com.tencent.lucasshi;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P703_kthLargest {
  public PriorityQueue<Integer> pq;
  private int k;

  public P703_kthLargest(int k, int[] nums) {
    pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });

    this.k = k;
    for (int i = 0; i < nums.length; i++) {
      add(nums[i]);
    }
  }

  public int add(int val) {
    if (pq.size() < k || val > pq.peek())
      pq.add(val);
    if (pq.size() > k)
      pq.poll();
    return pq.peek();
  }
}