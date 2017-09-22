package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/21.
 */
public class P661_ImageSmoother {
    public int getSmoothResult(int[][] M, int pi, int pj) {
        int sum = 0;
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i + pi >= 0 && i + pi < M.length) {
                    if (j + pj >= 0 && j + pj < M[0].length) {
                        sum += (M[i + pi][j + pj] & 0x0000ffff);
                        count++;
                    }
                }
            }
        }
        System.out.println(pi + " " + pj + " " + sum);
        return sum / count;
    }

    public int[][] imageSmoother(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int sum = getSmoothResult(M, i, j);
                sum = sum << 16;
                M[i][j] = (M[i][j] | sum);
            }
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                // System.out.print((M[i][j] >> 16) + " ");
                M[i][j] = (M[i][j] >> 16);
            }

        }

        return M;
    }

    public static void main(String[] args) {
        P661_ImageSmoother p = new P661_ImageSmoother();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        p.imageSmoother(matrix);

        LtCommon.printMatrix(matrix);
    }
}
