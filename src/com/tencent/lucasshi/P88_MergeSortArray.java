package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/27.
 */
public class P88_MergeSortArray {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int mindex = 0;
        int nindex = 0;

        for (int i = 0; i < result.length; i++) {
            if (mindex >= nums1.length || nums1[mindex] > nums2[nindex]) {
                result[i] = nums2[nindex];
                nindex += 1;
            } else if (nindex >= nums2.length || nums2[nindex] > nums1[mindex]) {
                result[i] = nums1[mindex];
                mindex += 1;
            }
        }

        return result;
    }
}
