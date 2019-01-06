package com.tentcent.lucasshi.facebook;

import java.util.HashMap;

/**
 * Created by fzy on 17/10/14.
 */
public class FaceBook_RangeQuery {
    int[][] sum;

    public int rangeQuery(int[][] nums, int x1, int y1, int x2, int y2) {
        int sum = 0;

        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                sum += nums[i][j];
            }
        }
        return sum;
    }

    public int rangeQueryV2(int[][] nums, int x1, int y1, int x2, int y2) {
        if (sum == null) {
            sum = new int[nums.length][nums[0].length];
            int culmulateVal = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[0].length; j++) {
                    culmulateVal += nums[i][j];
                    sum[i][j] = culmulateVal;
                }
            }
        }

        int val = sum[x2][y2] + sum[x1][y1] - sum[x1][y2] - sum[x2][y1];

        return val;
    }

}
