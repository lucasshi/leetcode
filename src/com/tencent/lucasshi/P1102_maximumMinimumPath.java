package com.tencent.lucasshi;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class P1102_maximumMinimumPath {
    class Point {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return 10001 * x + y;
            // return Objects.hash(x, y);
        }
    }

    public static int MAX = Integer.MIN_VALUE;
    public int maximumMinimumPath(int[][] grid) {
        HashSet<Point> visited = new HashSet<>();
        dfs(0, 0, visited, grid, Integer.MAX_VALUE);
        return MAX;
    }

    public void dfs(int x, int y, Set<Point> visited, int[][] grid, int min) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return;

        if (visited.contains(new Point(x, y)))
            return;

        int rootMin = Math.min(min, grid[x][y]);
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            MAX = Math.max(MAX, rootMin);
            return;
        }

        visited.add(new Point(x, y));
        dfs(x + 1, y, visited, grid, rootMin);
        dfs(x - 1, y, visited, grid, rootMin);
        dfs(x, y + 1, visited, grid, rootMin);
        dfs(x, y - 1, visited, grid, rootMin);
        visited.remove(new Point(x, y));
    }

    public static void main(String[] args) {
        int[][] grid = {{3,3,2,0,2,2,3},{0,2,3,0,0,2,0},{3,0,2,1,1,1,1},{3,0,0,0,2,2,0},{2,2,3,0,2,2,3}};
        P1102_maximumMinimumPath p = new P1102_maximumMinimumPath();
        System.out.println(p.maximumMinimumPath(grid));
    }
}
