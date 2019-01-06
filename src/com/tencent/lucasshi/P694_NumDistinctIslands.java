package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class P694_NumDistinctIslands {
    private HashSet<String> islands = new HashSet<>();

    public String getHashing(ArrayList<int[]> points) {
        int[] p0 = points.get(0);
        String result = "";
        for (int i = 0; i < points.size(); i++) {
            result += points.get(i)[0] - p0[0] + ",";
            result += points.get(i)[1] - p0[1] + ",";
        }
        return result;
    }

    public int numDistinctIslands(int[][] grid) {
        ArrayList<int[]> points = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[1].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                visited[i][j] = false;

        // traverse
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    String hashresult = getHashing(points);
                    if (!islands.contains(hashresult))
                        islands.add(hashresult);
                    points.clear();
                    dfs(grid, visited, i, j, points);
                }
            }
        }

        return islands.size();
    }

    public void dfs(int[][] grid, boolean[][] visited, int i, int j, ArrayList<int[]> points) {
        if (i > grid.length || j > grid[0].length || i < 0 || j < 0)
            return;
        if (visited[i][j] || grid[i][j] == 0)
            return;
        visited[i][j] = true;
        points.add(new int[]{i, j});
        dfs(grid, visited, i + 1, j, points);
        dfs(grid, visited, i - 1, j, points);
        dfs(grid, visited, i, j + 1, points);
        dfs(grid, visited, i, j - 1, points);
    }
}
