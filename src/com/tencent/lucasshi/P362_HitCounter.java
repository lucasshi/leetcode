package com.tencent.lucasshi;

public class P362_HitCounter {
    private int[] hits = new int[300];

    void hit(int timestamp) {
        int index = timestamp % 300;
        hits[index] = timestamp;
    }

    int getHits(int timestamp) {
        int count = 0;
        for (int i = 0; i < hits.length; i++) {
            if (timestamp - hits[i] < 300) {
                count += 1;
            }
        }
        return count;
    }
}
