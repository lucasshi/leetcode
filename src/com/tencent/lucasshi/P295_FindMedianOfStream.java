package com.tencent.lucasshi;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P295_FindMedianOfStream {
    private PriorityQueue<Integer> minPq;
    private PriorityQueue<Integer> maxPq;

    public P295_FindMedianOfStream() {
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (minPq.size() == 0) {
            minPq.add(num);
            return;
        }

        if (minPq.size() > maxPq.size()) {
            // add to maxPq
            if (num > minPq.peek()) {
                int sNumber = minPq.poll();
                minPq.add(num);
                maxPq.add(sNumber);
            } else {
                maxPq.add(num);
            }
        } else {
            // add to minPq
            if (num < maxPq.peek()) {
                int sNumber = maxPq.poll();
                minPq.add(sNumber);
                maxPq.add(num);
            } else {
                minPq.add(num);
            }
        }
    }

    public double findMedian() {
        if (minPq.size() == maxPq.size())
            return (minPq.peek() + maxPq.peek()) / 2.0;
        return minPq.peek();
    }
}
