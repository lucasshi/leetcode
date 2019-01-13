package com.tencent.lucasshi;

public class P733_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int max = -1;
        boolean[][] visited = new boolean[image.length][image[0].length];
        for (int i = 0; i < image.length; i++)
            for (int j = 0; j < image[i].length; j++)
                visited[i][j] = false;
        int oldColor = image[sr][sc];
        dfs(image, visited, sr, sc, oldColor, newColor);
        return image;
    }

    public int dfs(int[][] grid, boolean[][] visited, int i, int j, int oldColor, int newColor) {
        if (i > grid.length - 1 || j > grid[0].length - 1 || i < 0 || j < 0)
            return 0;
        if (visited[i][j] || grid[i][j] != oldColor)
            return 0;
        visited[i][j] = true;
        grid[i][j] = newColor;
        int l = dfs(grid, visited, i + 1, j, oldColor, newColor);
        int r = dfs(grid, visited, i - 1, j, oldColor, newColor);
        int u = dfs(grid, visited, i, j + 1, oldColor, newColor);
        int d = dfs(grid, visited, i, j - 1, oldColor, newColor);
        return l + r + u + d + 1;
    }
}
