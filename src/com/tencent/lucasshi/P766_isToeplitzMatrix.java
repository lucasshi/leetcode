package com.tencent.lucasshi;

public class P766_isToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int startX = 0;
        for (int i = 0; i < matrix.length; i++) {
            int startY = i;
            int cursor = matrix[startX][startY];
            for (int j = 0; j + startY < matrix[0].length; j++) {
                if (matrix[startX + j][startY + j] != cursor)
                    return false;
            }
        }

        int startY = 0;
        for (int i = 0; i < matrix.length; i++) {
            startX = i;
            int cursor = matrix[startX][startY];
            for (int j = 0; j + startX < matrix.length; j++) {
                if (matrix[startX + j][startY + j] != cursor)
                    return false;
            }
        }
        return true;
    }
}
