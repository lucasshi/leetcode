package com.tencent.lucasshi;

import java.util.Random;

public class P528_RandomPickWeight {
    private int[] sums;
    private Random random;
    public P528_RandomPickWeight(int[] w) {
        int sum = 0;
        random = new Random();
        sums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            sums[i] = sum;
        }
    }

    public int pickIndex() {
        int totalSum = sums[sums.length - 1];
        int value = random.nextInt(totalSum);
        int left = 0;
        int right = sums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (sums[mid] < value) {
                left = mid + 1;
            } else if (sums[mid] > value) {
                right = mid;
            } else if (sums[mid] == value) {
                right = mid;
                break;
            }
        }

        // right
        return right;
    }
}
