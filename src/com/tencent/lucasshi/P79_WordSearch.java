package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/28.
 */
public class P79_WordSearch {
    public boolean exist(char[][] board, String word) {
        int hLength = board.length;
        int vLength = board[0].length;

        boolean[][] visited = new boolean[hLength][vLength];
        for (int i = 0; i < hLength; i++) {
            for (int j = 0; j < vLength; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (DFS(board, word, i, j, visited) == true) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean DFS(char[][] board, String word, int i, int j, boolean[][] visted) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visted[i][j]) {
            return false;
        }

        visted[i][j] = true;
        if (board[i][j] != word.charAt(0)) {
            return false;
        }

        if (word.length() == 1 && board[i][j] == word.charAt(0)) {
            return true;
        }

        boolean result = false;
        result = DFS(board, word.substring(1), i + 1, j, visted);
        result = result || DFS(board, word.substring(1), i - 1, j, visted);
        result = result || DFS(board, word.substring(1), i, j + 1, visted);
        result = result || DFS(board, word.substring(1), i, j - 1, visted);

        visted[i][j] = false;
        return result;
    }
}
