package com.tentcent.lucasshi.facebook;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_BalancedPoint {
    private int balancedPoint(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        if (sum % 2 != 0)
            return -1;

        int leftSum = 0;
        for (int i = 0; i < a.length; i++) {
            leftSum += a[i];
            if (leftSum == sum / 2)
                return i;
        }
        return -1;
    }
}
