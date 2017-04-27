package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/27.
 */
public class P88_MergeSortArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int m1LastIndex = m - 1;
        int m2LastIndex = n - 1;
        int LastIndex = m + n - 1;

        while (LastIndex >= 0 && m2LastIndex >= 0 && m1LastIndex >= 0) {
            if (nums1[m1LastIndex] > nums2[m2LastIndex]) {
                nums1[LastIndex] = nums1[m1LastIndex];
                m1LastIndex--;
            } else {
                nums1[LastIndex] = nums2[m2LastIndex];
                m2LastIndex--;
            }

            LastIndex--;
        }

        if (m2LastIndex >= 0) {
            for (int i = m2LastIndex; i >= 0; i--) {
                nums1[LastIndex] = nums2[i];
                LastIndex--;
            }
        }

        if (m1LastIndex >= 0) {
            for (int i = m1LastIndex; i >= 0; i--) {
                nums1[LastIndex] = nums1[i];
                LastIndex--;
            }
        }
    }
}
