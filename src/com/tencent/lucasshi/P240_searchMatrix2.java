package com.tencent.lucasshi;

/**
 * Created by fzy on 17/7/30.
 */
public class P240_searchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int i = 0, j = width - 1;

        while (i < height && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
                continue;
            }

            if (matrix[i][j] < target) {
                i++;
                continue;
            }

            return true;
        }

        return false;
        // 可以从四个方向去搜索这个值
    }

    public boolean searchMatrixV2(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0)
            return false;

        int width = matrix[0].length;
        int index = -1;

        //
        for (index = 0; index < matrix.length; index++) {
            if (target < matrix[index][index]) {
                break;
            }
        }

        for (int i = 0; i <= index; i++) {
            if (matrix[i][index] == target)
                return true;
            if (matrix[index][i] == target)
                return true;
        }

        return false;
    }
}
