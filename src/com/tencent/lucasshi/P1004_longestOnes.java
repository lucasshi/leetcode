package com.tencent.lucasshi;

public class P1004_longestOnes {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int zeroCount = 0;
        int result = 0;

        for (int right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                zeroCount += 1;
            }

            while (zeroCount > K) {
                if (A[left] == 1) {
                    left++;
                } else {
                    zeroCount--;
                    left++;
                }
            }

            result = Math.min(right - left + 1, result);
        }

        return result;
    }
}
