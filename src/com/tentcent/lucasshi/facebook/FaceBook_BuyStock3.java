package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/8.
 */
public class FaceBook_BuyStock3 {
    public int bestBuyStock2(int[] values) {
        int[] frontDp = new int[values.length];
        int[] backDp = new int[values.length];

        // 可以赚的钱
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            min = Math.min(values[i], min);
            frontDp[i] = values[i] - min;
        }

        int max = Integer.MIN_VALUE;
        for (int i = values.length - 1; i >= 0; i--) {
            max = Math.max(values[i], max);
            backDp[i] = max - values[i];
        }

        // 领边看
        for (int i = 0; i < values.length; i++) {

        }
        return -1;

    }
}
