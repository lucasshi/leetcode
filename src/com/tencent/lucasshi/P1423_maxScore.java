package com.tencent.lucasshi;

public class P1423_maxScore {
    public int maxScore(int[] cardPoints, int k) {
        int[] lsum = new int[cardPoints.length];
        int[] rsum = new int[cardPoints.length];

        int sum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
           sum += cardPoints[i];
           lsum[i] = sum;
        }

        sum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[cardPoints.length - 1 - i];
            rsum[i] = sum;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            if (i == 0) {
                maxSum = Math.max(maxSum, rsum[k - 1]);
            } else if (i == k) {
                maxSum = Math.max(maxSum, lsum[k - 1]);
            } else {
                maxSum = Math.max(lsum[i - 1] + rsum[k - i - 1], maxSum);
            }
        }

        return maxSum;
    }
}
