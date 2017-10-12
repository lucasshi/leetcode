package com.tentcent.lucasshi.facebook;

import java.util.Arrays;

/**
 * Created by fzy on 17/10/10.
 */
public class FaceBook_FindSortArray {
    public double findMedianSortedArrays(int A[], int B[]) {
        int aMidIndex = A.length / 2;
        int bMidIndex = B.length / 2;

        int aMid = A[aMidIndex];
        int bMid = B[bMidIndex];

        if (aMid < bMid) {
            findMedianSortedArrays(Arrays.copyOfRange(A, aMidIndex + 1, A.length),
                    Arrays.copyOfRange(B, 0, bMidIndex - 1));
        } else if (aMid > bMid) {
            findMedianSortedArrays(Arrays.copyOfRange(B, bMidIndex + 1, B.length),
                    Arrays.copyOfRange(A, 0, aMidIndex - 1));
        } else {
            return A[aMidIndex];
        }

        return -1;
    }
}
