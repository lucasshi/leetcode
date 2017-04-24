package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 17/4/23.
 */
public class P60_PermutationSequence {
    public static String getPermutation(int n, int k) {
        int[] powArray = new int[n];
        boolean[] avail = new boolean[n];

        // 计算所有的阶乘
        int pow = 1;
        for (int i = 0; i < n; i++) {
            pow = (i + 1) * pow;
            powArray[i] = pow;
        }

        String result = "";
        for (int j = n - 2; j >= 0; j--) {
            pow = powArray[j];
            int index = (k - 1) / pow;
            if (index > 0) {
                k = k - pow * index;
            }

            // 进行处理
            int totalIndex = 0;
            for (int i = 0; i < n; i++) {
                if (totalIndex >= index && avail[i] != true) {
                    avail[i] = true;
                    totalIndex = i;
                    break;
                }

                if (avail[i] == false) {
                    totalIndex++;
                }
            }

            result += (totalIndex + 1);
        }

        for (int i = 0; i < n; i++) {
            if (avail[i] == false) {
                return result + (i + 1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(P60_PermutationSequence.getPermutation(3, 3));
    }
}
