package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/25.
 */
public class P85_MaxRectangle {
    public int maximalRectangle(char[][] matrix) {
        int hLength = matrix.length;
        int vLength = matrix[0].length;

        int[][] dpWidth = new int[hLength][vLength];
        int[][] dpHeight = new int[hLength][vLength];

        if (matrix[0][0] == '1') {
            dpWidth[0][0] = 1;
            dpHeight[0][0] = 1;
        }

        int maxSize = 0;
        // hLegnth
        for (int i = 1; i < hLength; i++) {
            if (matrix[i][0] == '0') {
                dpHeight[i][0] = 0;
                dpWidth[i][0] = 0;
                continue;
            }

            dpHeight[i][0] = dpHeight[i - 1][0] + 1;
            dpWidth[i][0] = 1;

            int size = dpHeight[i][0] * dpWidth[i][0];
            maxSize = Math.max(maxSize, size);
        }

        for (int i = 1; i < vLength; i++) {
            if (matrix[0][i] == '0') {
                dpWidth[0][i] = 0;
                dpHeight[0][i] = 0;
                continue;
            }

            dpWidth[0][i] = dpWidth[0][i - 1] + 1;
            dpHeight[0][i] = 1;

            int size = dpHeight[0][i] * dpWidth[0][i];
            maxSize = Math.max(maxSize, size);
        }

        // dp
        for (int i = 1; i < hLength; i++) {
            for (int j = 1; j < vLength; j++) {
                if (matrix[i][j] == '0') {
                    dpHeight[i][j] = 0;
                    dpWidth[i][j] = 0;
                    maxSize = Math.max(0, maxSize);
                    continue;
                }

                if (matrix[i - 1][j - 1] == '0') {
                    int width = dpWidth[i][j - 1] + 1;
                    int height = dpHeight[i - 1][j] + 1;
                    if (width > height) {
                        dpWidth[i][j] = width;
                        dpHeight[i][j] = 1;
                    } else {
                        dpHeight[i][j] = height;
                        dpWidth[i][j] = 1;
                    }

                    int size = dpHeight[i][j] * dpWidth[i][j];
                    maxSize = Math.max(maxSize, size);
                    continue;
                }

                if (matrix[i - 1][j] == '0') {
                    int width = dpWidth[i][j - 1] + 1;
                    int height = 1;

                    dpWidth[i][j] = width;
                    dpHeight[i][j] = height;

                    int size = dpHeight[i][j] * dpWidth[i][j];
                    maxSize = Math.max(maxSize, size);
                    continue;
                }

                if (matrix[i][j - 1] == '0') {
                    int height = dpHeight[i - 1][j] + 1;
                    int width = 1;

                    dpWidth[i][j] = width;
                    dpHeight[i][j] = height;

                    int size = dpHeight[i][j] * dpWidth[i][j];
                    maxSize = Math.max(maxSize, size);
                    continue;
                }


                int minHeight = Math.min(dpHeight[i - 1][j], dpHeight[i][j - 1]);
                int minWidth = Math.min(dpWidth[i - 1][j], dpWidth[i][j - 1]);

                dpHeight[i][j] = minHeight + 1;
                dpWidth[i][j] = minWidth + 1;

                int size = dpHeight[i][j] * dpWidth[i][j];
                maxSize = Math.max(maxSize, size);
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'0', '1', '1', '0', '1'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '0'}};

    }
}
