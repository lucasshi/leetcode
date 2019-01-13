package com.tencent.lucasshi;

import java.util.ArrayList;

public class P695_MaxAreaOfIsland {
    public int numDistinctIslands(int[][] grid) {
        int max = -1;
        boolean[][] visited = new boolean[grid.length][grid[1].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                visited[i][j] = false;

        // traverse
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int size = dfs(grid, visited, i, j);
                    max = Math.max(size, max);
                    System.out.println(size);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i > grid.length || j > grid[0].length || i < 0 || j < 0)
            return 0;
        if (visited[i][j] || grid[i][j] == 0)
            return 0;
        visited[i][j] = true;
        int l = dfs(grid, visited, i + 1, j);
        int r = dfs(grid, visited, i - 1, j);
        int u = dfs(grid, visited, i, j + 1);
        int d = dfs(grid, visited, i, j - 1);
        return l + r + u + d + 1;
    }
}
