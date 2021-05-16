package com.tencent.lucasshi;

public class P463_islandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0)
                        result++;
                    if (j == 0 || grid[i][j - 1] == 0)
                        result++;
                    if (i == grid.length - 1 || grid[i + 1][j] == 0)
                        result++;
                    if (j == grid[0].length - 1 || grid[i][j + 1] == 0)
                        result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P463_islandPerimeter p463_islandPerimeter = new P463_islandPerimeter();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(p463_islandPerimeter.islandPerimeter(grid));
    }
}
