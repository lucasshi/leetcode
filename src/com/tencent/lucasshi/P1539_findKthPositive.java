package com.tencent.lucasshi;

public class P1539_findKthPositive {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int idx = (left + right) / 2;
            if (arr[idx] - idx == k) {
                return get(arr, idx);
            } else if (arr[idx] - idx > k) {
                right = idx - 1;
            } else {
                left = idx + 1;
            }
        }

        return -1;
    }

    public int get(int[] arr, int idx) {
       for (int i = idx; i > 0; i--) {
           if (arr[i] - arr[i - 1] != 1)
               return arr[i] - 1;
       }
       return arr[0] - 1;
    }
}
