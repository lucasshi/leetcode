package com.tencent.lucasshi;

import java.util.Queue;

import java.util.LinkedList;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class P130_SroundRegion {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        Queue queue = new LinkedList<Pair>();
        //对所有在边上的O节点进行BFS
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == (board.length - 1) || j == 0 || j == (board[0].length - 1)) {
                    if (board[i][j] == 'O') {
                        Pair position = new Pair(i, j);
                        queue.add(position);
                    }
                }
            }
        }
        int x1, y1;
        //BFS
        while (!queue.isEmpty()) {
            Pair position = (Pair) queue.poll();
            x1 = position.x;
            y1 = position.y;

            if (board[x1][y1] == 'Y') {
                continue;
            }
            //四个方向查找，找到为'O'的节点放入队列中。
            //left
            board[x1][y1] = 'Y';
            int index = x1 - 1;
            if (index >= 0 && board[index][y1] == 'O') {
                queue.add(new Pair(index, y1));
            }
            //right
            index = x1 + 1;
            if (index < board.length && board[index][y1] == 'O') {
                queue.add(new Pair(index, y1));
            }
            //up
            index = y1 + 1;
            if (index < board[0].length && board[x1][index] == 'O') {
                queue.add(new Pair(x1, index));
            }
            //down
            index = y1 - 1;
            if (index >= 0 && board[x1][index] == 'O') {
                queue.add(new Pair(x1, index));
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }
        return;
    }

    public void solve1(char[][] board) {

    }

    public boolean dfs(char[][] board, boolean[][] visited, int x, int y) {
        if (visited[x][y])
            return true;
        visited[x][y] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < dirs.length; i++) {
            int dx = x + dirs[i][0];
            int dy = x + dirs[i][1];

            if (dx < 0 || dy < 0 || dx >= board.length || dy >= board[0].length)
                continue;
            if (board[dx][dy] == '$')
                return false;
            if (!dfs(board, visited, dx, dy))
                return false;
        }
        return true;
    }
}