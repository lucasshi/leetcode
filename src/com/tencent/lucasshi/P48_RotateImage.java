package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/17.
 */
public class P48_RotateImage {
    public void rotate(int[][] matrix) {
        int round = matrix.length / 2;

        for (int i = 0; i <= round; i++) {
            rotateRound(matrix, i);
        }
        return;
    }

    public void rotateRound(int[][] matrix, int roundId) {
        int end = matrix.length - 1 - roundId;
        // int length = matrix.length;

        /*
        for (int i = roundId; i < end; i++) {
            int first = matrix[roundId][i];
            int second = matrix[i][end];
            int third = matrix[end][length - i - 1];
            int fourth = matrix[length - i - 1][roundId];

            // swap
            matrix[i][end] = first;
            matrix[end][length - i - 1] = second;
            matrix[length - i - 1][roundId] = third;
            matrix[roundId][i] = fourth;
        }
        */

        for (int i = 0; i < end - roundId; i++) {
            int first = matrix[roundId][roundId + i];
            int second = matrix[roundId + i][end];
            int third = matrix[end][end - i];
            int fourth = matrix[end - i][roundId];

            // swap
            matrix[roundId][roundId + i] = fourth;
            matrix[roundId + i][end] = first;
            matrix[end][end - i] = second;
            matrix[end - i][roundId] = third;

            printMatrix(matrix);
        }

    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ",");
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        P48_RotateImage p = new P48_RotateImage();

        p.printMatrix(matrix2);
        System.out.println("start");
        //p.FaceBook_RotateMin(matrix);
        p.rotate(matrix2);

    }
}
