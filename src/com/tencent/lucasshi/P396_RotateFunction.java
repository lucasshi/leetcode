package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/17.
 */
public class P396_RotateFunction {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        int start = 0;
        for (int i = 0; i < A.length; i++) {
            start += A[i] * i;
        }

        int max = start;
        int p = start;
        for (int i = A.length; i > 0; i++) {
            int leftSum = sum - A[i];
            int beZero = A[i] * (A.length - 1);

            p = p + leftSum - beZero;
            max = Math.max(p, max);
        }

        return max;
    }
}
