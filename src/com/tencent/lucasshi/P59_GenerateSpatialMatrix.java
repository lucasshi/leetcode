package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/23.
 */
public class P59_GenerateSpatialMatrix {
    public int[][] generateMatrix(int n) {
        int hLength = n;
        int vLength = n;
        int i = 0;
        int j = 0;

        if (n == 0) {
            return null;
        }

        int[][] matrix = new int[n][n];
        matrix[i][j] = 1;

        for (int num = 2; num <= n * n; num++) {
            int top = i;
            int bottom = hLength - 1 - i;
            int left = j;
            int right = vLength - 1 - j;
            int roundIndex = Math.min(top, Math.min(bottom, Math.min(left, right)));

            // 在顶部
            if (top == roundIndex && right == roundIndex) {
                matrix[++i][j] = num;
                continue;
            } else if (top == roundIndex) {
                matrix[i][++j] = num;
                continue;
            }

            // 在右边
            if (right == roundIndex && bottom == roundIndex) {
                matrix[i][--j] = num;
                continue;
            } else if (right == roundIndex) {
                matrix[++i][j] = num;
                continue;
            }

            // 在底部
            if (bottom == roundIndex && left == roundIndex) {
                matrix[--i][j] = num;
                continue;
            } else if (bottom == roundIndex) {
                matrix[i][--j] = num;
                continue;
            }

            // 在左边
            if (left == roundIndex && top == roundIndex + 1) {
                matrix[i][++j] = num;
                continue;
            } else {
                matrix[--i][j] = num;
                continue;
            }
        }

        return matrix;
    }
}
