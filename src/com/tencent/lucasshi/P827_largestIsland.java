package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class P827_largestIsland {
    class Point {
        public final int x;
        public final int y;

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
            return Objects.hash(x, y);
        }
    }


    public void dfsV2(boolean[][] visited, int[][] grid, int i, int j, boolean isChanged, List<Point> points) {
        if (i < 0 || j < 0)
            return;
        if (i > grid.length || j > grid[0].length)
            return;

        if (visited[i][j] == true)
            return;

        visited[i][j] = true;
        if (grid[i][j] == 0) {
            if (isChanged == false) {
                dfsV2(visited, grid, i + 1, j, true, points);
                dfsV2(visited, grid, i - 1, j, true, points);
                dfsV2(visited, grid, i, j + 1, true, points);
                dfsV2(visited, grid, i, j - 1, true, points);
            }
        } else {
            dfsV2(visited, grid, i + 1, j, isChanged, points);
            dfsV2(visited, grid, i - 1, j, isChanged, points);
            dfsV2(visited, grid, i, j + 1, isChanged, points);
            dfsV2(visited, grid, i, j - 1, isChanged, points);
        }
    }

    public int largestIslandV1(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<Point> points = new ArrayList<>();
        int[][] area = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(visited, grid, i, j, points);
                for (Point p:points) {
                    area[p.x][p.y] = points.size();
                }

                Set<Point> boundPoints = new HashSet<>();
                for (Point p: points) {
                    if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 0) {
                        boundPoints.add(new Point(p.x - 1, p.y));
                    } else if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == 0) {
                        boundPoints.add(new Point(p.x + 1, p.y));
                    } else if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 0) {
                        boundPoints.add(new Point(p.x, p.y - 1));
                    } else if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 0) {
                        boundPoints.add(new Point(p.x, p.y + 1));
                    }
                }

                for (Point bp: boundPoints) {
                    if (area[bp.x][bp.y] == 0)
                        area[bp.x][bp.y] += points.size() + 1;
                    else
                        area[bp.x][bp.y] += points.size();
                }
                points.clear();
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; i < area[0].length; j++) {
                max = Math.max(max, area[i][j]);
            }
        }
        return max;
    }

    public void dfs(boolean[][] visited, int[][] grid, int i, int j, List<Point> points) {
        if (i < 0 || j < 0)
            return;
        if (i > grid.length || j > grid[0].length)
            return;

        if (visited[i][j] == true)
            return;

        visited[i][j] = true;
        if (grid[i][j] == 0) {
            return;
        } else {
            points.add(new Point(i, j));
            dfs(visited, grid, i + 1, j, points);
            dfs(visited, grid, i - 1, j, points);
            dfs(visited, grid, i, j + 1, points);
            dfs(visited, grid, i, j - 1, points);
        }
    }

}
