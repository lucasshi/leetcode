package com.tencent.lucasshi;

import java.util.ArrayList;

public class P933_sortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        ArrayList<Integer> oddIndex = new ArrayList<>();
        ArrayList<Integer> evenIndex = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == A[i] % 2) {
                continue;
            }
            if (i % 2 == 0) {
                oddIndex.add(i);
            } else {
                evenIndex.add(i);
            }
        }

        // do
        for (int i = 0; i < oddIndex.size(); i++) {
            int temp = A[oddIndex.get(i)];
            A[oddIndex.get(i)] = A[evenIndex.get(i)];
            A[evenIndex.get(i)] = temp;
        }

        return A;
    }

    public static void main(String[] args) {
        P933_sortArrayByParityII p = new P933_sortArrayByParityII();
        // int[] A = {3, 0, 4, 0, 2, 1, 3, 1, 3, 4};
        int[] A = {648, 831, 560, 986, 192, 424, 997, 829, 897, 843};

        p.sortArrayByParityII(A);
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + ",");
    }
}
