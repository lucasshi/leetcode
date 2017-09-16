package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fzy on 17/9/16.
 */
public class P311_SparseMatrix {
    // rowId, columnId, value
    private HashMap<Integer, HashMap<Integer, Integer>> AIndex = new HashMap<>();
    private HashMap<Integer, HashMap<Integer, Integer>> BIndex = new HashMap<>();

    public int multiplyRowColumn(int i, int j) {
        HashMap<Integer, Integer> row = AIndex.get(i);
        HashMap<Integer, Integer> colum = BIndex.get(j);

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : row.entrySet()) {
            int key = entry.getKey();
            if (colum.containsKey(key)) {
                sum += colum.get(key) * entry.getValue();
            }
        }

        return sum;
    }

    public int[][] multiply(int[][] A, int[][] B) {
        // Build AIndex
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int val = A[i][j];
                if (!AIndex.containsKey(i)) {
                    AIndex.put(i, new HashMap<>());
                }
                if (val != 0) {
                    AIndex.get(i).put(j, val);
                }
            }
        }
        // Build BIndex
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                int val = B[i][j];
                if (!BIndex.containsKey(j)) {
                    BIndex.put(j, new HashMap<>());
                }
                if (val != 0) {
                    BIndex.get(j).put(i, val);
                }
            }
        }

        // DoMultipyy
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                result[i][j] = multiplyRowColumn(i, j);
            }
        }
        return result;
    }
}
