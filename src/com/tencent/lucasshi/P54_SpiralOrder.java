package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by fzy on 17/4/23.
 */
public class P54_SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int hLength = matrix.length;
        int vLength = matrix[0].length;

        if (hLength == 0) {
            return new ArrayList<>();
        }
        boolean[][] visited = new boolean[hLength][vLength];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                visited[i][j] = false;
            }
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n = hLength;
        int m = vLength;
        result.add(matrix[0][0]);
        while (result.size() != hLength * vLength) {
            int top = i;
            int bottom = n - 1 - i;
            int left = j;
            int right = m - 1 - j;
            int roundIndex = Math.min(top, Math.min(bottom, Math.min(left, right)));

            // 在顶部
            if (top == roundIndex && right == roundIndex) {
                result.add(matrix[++i][j]);
                continue;
            } else if (top == roundIndex) {
                result.add(matrix[i][++j]);
                continue;
            }

            // 在右边
            if (right == roundIndex && bottom == roundIndex) {
                result.add(matrix[i][--j]);
                continue;
            } else if (right == roundIndex) {
                result.add(matrix[++i][j]);
                continue;
            }

            // 在底部
            if (bottom == roundIndex && left == roundIndex) {
                result.add(matrix[--i][j]);
                continue;
            } else if (bottom == roundIndex) {
                result.add(matrix[i][--j]);
                continue;
            }

            // 在左边
            if (left == roundIndex && top == roundIndex + 1) {
                result.add(matrix[i][++j]);
                continue;
            } else {
                result.add(matrix[--i][j]);
                continue;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        List<Integer> result = P54_SpiralOrder.spiralOrder(matrix);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
