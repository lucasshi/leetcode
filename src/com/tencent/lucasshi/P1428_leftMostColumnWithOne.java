package com.tencent.lucasshi;

import java.util.List;

public class P1428_leftMostColumnWithOne {
    class BinaryMatrix {
        List<Integer> dimensions() {
            return null;
        }

        int get(int i, int j) {
            return 0;
        }
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int height = binaryMatrix.dimensions().get(0);
        int width = binaryMatrix.dimensions().get(1);

        int i = height - 1;
        int j = width - 1;
        int res = -1;
        while (i >= 0 && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) {
                res = j;
                j--;
            } else {
                i--;
            }
        }

        return res;
    }
}
