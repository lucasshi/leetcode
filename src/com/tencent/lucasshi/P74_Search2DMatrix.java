package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/25.
 */
public class P74_Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }

        int hLength = matrix.length;
        if (hLength == 0) {
            return false;
        }

        int vLength = matrix[0].length;

        int mid = (hLength * vLength - 1) / 2;
        int start = 0;
        int end = hLength * vLength - 1;

        while (start <= end) {
            System.out.println(start + " " + end + " " + mid);
            int midI = mid / vLength;
            int midJ = mid % vLength;

            if (matrix[midI][midJ] == target) {
                return true;
            } else if (matrix[midI][midJ] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = (start + end) / 2;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};

        System.out.println(searchMatrix(matrix, 3));
    }
}
