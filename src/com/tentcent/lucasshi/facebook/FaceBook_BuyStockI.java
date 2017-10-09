package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/8.
 */
public class FaceBook_BuyStockI {
    public int bestBuyStock1(int[] values) {
        int min = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < values.length; i++) {
            min = Math.min(values[i], min);
            maxDiff = Math.max(values[i] - min, maxDiff);
        }

        return maxDiff;
    }
}
