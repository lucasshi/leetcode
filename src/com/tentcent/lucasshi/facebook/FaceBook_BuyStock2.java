package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/8.
 */
public class FaceBook_BuyStock2 {
    public int bestBuyStock2(int[] values) {
        int max = 0;
        for (int i = 1; i < values.length; i++) {
            int diff = values[i] > values[i - 1] ? values[i] - values[i - 1] : 0;
            max += diff;
        }
        return max;
    }
}
