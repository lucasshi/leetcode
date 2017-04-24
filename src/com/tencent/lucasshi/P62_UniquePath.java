package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/24.
 */
public class P62_UniquePath {
    public int uniquePaths(int m, int n) {
        if (n == 1 || m == 1) return 1;

        int[] A = new int[n];
        for (int i = 1; i <= n; i++) {
            A[i - 1] = i;//i-1写出i会造成下标超范围
        }

        for (int i = 2; i < m; i++) {
            for (int j = 1; j < n; j++) {
                A[j] += A[j - 1];
            }
        }
        return A[n - 1];
    }
}
