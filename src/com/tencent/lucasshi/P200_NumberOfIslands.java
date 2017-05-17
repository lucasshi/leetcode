package com.tencent.lucasshi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by fzy on 17/5/16.
 */
public class P200_NumberOfIslands {
    class Pair {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        boolean[][] visited = new boolean[height][width];

        int result = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    public void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int px = p.x;
            int py = p.y;

            // 四个方向进行BFS
            if (px - 1 >= 0 && grid[px - 1][py] == '1' && !visited[px - 1][py]) {
                queue.offer(new Pair(px - 1, py));
                visited[px - 1][py] = true;
            }

            if (py - 1 >= 0 && grid[px][py - 1] == '1' && !visited[px][py - 1]) {
                queue.offer(new Pair(px, py - 1));
                visited[px][py - 1] = true;
            }

            if (px + 1 < grid.length && grid[px + 1][py] == '1' && !visited[px + 1][py]) {
                queue.offer(new Pair(px + 1, py));
                visited[px + 1][py] = true;
            }

            if (py + 1 < grid[0].length && grid[px][py + 1] == '1' && !visited[px + 1][py]) {
                queue.offer(new Pair(px, py + 1));
                visited[px][py + 1] = true;
            }
        }
    }
}
