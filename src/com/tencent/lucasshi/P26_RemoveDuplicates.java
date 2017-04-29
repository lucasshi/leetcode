package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/28.
 */
public class P26_RemoveDuplicates {
    public int removeDuplicates(int[] A) {
        int length = A.length;
        if (length == 0) {
            return 0;
        }

        int tmp = A[0];
        int cnt = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] != tmp) {
                A[cnt] = A[i];
                tmp = A[i];
                cnt++;
            }
        }

        return cnt;
    }
}
