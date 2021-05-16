package com.tencent.lucasshi;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P973_kClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k,
                (o1, o2) -> points[o2][0] * points[o2][0] + points[o2][1] * points[o2][1] - points[o1][0] * points[o1][0] + points[o1][1] * points[o1][1]);
        for (int i = 0; i < points.length; i++)
            priorityQueue.add(i);

        System.out.println(priorityQueue);
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int index = priorityQueue.poll();
            result[i][0] = points[index][0];
            result[i][1] = points[index][1];
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] input = {{0, 1}, {1, 0}};
        P973_kClosest p973_kClosest = new P973_kClosest();
        p973_kClosest.kClosest(input, 2);
    }
}
