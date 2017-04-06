package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fzy on 17/3/27.
 */
public class P36_IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        HashMap<Character, Boolean>[] rowIndex = new HashMap[board.length];
        HashMap<Character, Boolean>[] colIndex = new HashMap[board.length];
        HashMap<Character, Boolean>[] blockIndex = new HashMap[board.length];

        for (int i = 0; i < length; i++) {
            rowIndex[i] = new HashMap<>();
            colIndex[i] = new HashMap<>();
            blockIndex[i] = new HashMap<>();
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char element = board[i][j];
                if (element != '.') {
                    // check row
                    if (rowIndex[i].containsKey(element)) {
                        return false;
                    }

                    // check col
                    if (colIndex[j].containsKey(element)) {
                        return false;
                    }

                    int rowSegmentId = i / 3;
                    int colSegmentId = j / 3;
                    int blockId = rowSegmentId * 3 + colSegmentId;
                    if (blockIndex[blockId].containsKey(element)) {
                        return false;
                    }

                    rowIndex[i].put(element, true);
                    colIndex[j].put(element, true);
                    blockIndex[blockId].put(element, true);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a = new int[10][10];
        System.out.print(a.length);
    }
}
