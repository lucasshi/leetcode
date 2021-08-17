package com.tencent.lucasshi;

public class SelectAlg {
    void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    int select(int[] array, int k, int sindex, int eindex) {
        int pvalue = array[sindex];
        int l = sindex + 1;
        int r = eindex;

        while (l < r) {
            if (array[l] < pvalue)
                l++;
            if (array[r] >= pvalue)
                r++;
            if (array[l] >= pvalue && array[r] < pvalue) {
                swap(array, l, r);
            }
        }

        swap(array, l, sindex);
        if (l == k)
            return array[l];
        else if (l < k)
            return select(array, k, l + 1, eindex);
        else
            return select(array, k, sindex, l - 1);

    }
}
