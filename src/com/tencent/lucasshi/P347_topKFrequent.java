package com.tencent.lucasshi;

import java.util.*;

public class P347_topKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!countMap.containsKey(nums[i]))
                countMap.put(nums[i], 0);
            countMap.put(nums[i], countMap.get(nums[i]) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return countMap.get(o1) - countMap.get(o2);
            }
        });

        for (Integer key : countMap.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(pq);
        return result;
    }

    public static void main(String[] args) {
        P347_topKFrequent p = new P347_topKFrequent();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(p.topKFrequent(nums, 2));
    }
}
