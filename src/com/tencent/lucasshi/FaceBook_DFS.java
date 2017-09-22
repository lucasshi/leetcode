package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by fzy on 17/9/19.
 */
public class FaceBook_DFS {
    private List<String> results = new ArrayList<>();
    private char[] path;

    public void DFS(char[][] matrix, int i, int j, int endIndex) {
        if (null == path) {
            path = new char[matrix.length + matrix[0].length - 2];
        }
        if (j >= matrix[0].length)
            return;
        if (i >= matrix.length)
            return;

        if (i == matrix.length - 1 && j == matrix.length - 1) {
            // results.add(path + matrix[i][j]);
            System.out.println(path);
            return;
        }

        path[endIndex] = matrix[i][j];
        DFS(matrix, i + 1, j, endIndex + 1);
        DFS(matrix, i, j + 1, endIndex + 1);
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };
        FaceBook_DFS fb = new FaceBook_DFS();
        fb.DFS(matrix, 0, 0, 0);
    }
}
