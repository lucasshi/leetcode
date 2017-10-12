package com.tentcent.lucasshi.facebook;

import java.util.*;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_WallAndGates {
    //   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4
    class Position {
        public int x;
        public int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        List<Position> levelList = new ArrayList<>();
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        // init
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    levelList.add(new Position(i, j));
                    visited[i][j] = true;
                }
            }
        }

        // do BFS
        int step = 0;
        while (!levelList.isEmpty()) {
            List<Position> nextLevelList = new ArrayList<>();
            for (Position p : levelList) {
                Position left = new Position(p.x - 1, p.y);
                Position right = new Position(p.x + 1, p.y);
                Position top = new Position(p.x, p.y - 1);
                Position bottom = new Position(p.x, p.y + 1);

                // do iteration
                if (left.x >= 0 && !visited[left.x][left.y] && rooms[left.x][left.y] != -1) {
                    nextLevelList.add(left);
                    rooms[left.x][left.y] = step + 1;
                    visited[left.x][left.y] = true;
                }

                if (right.x < rooms.length && !visited[right.x][right.y] && rooms[right.x][right.y] != -1) {
                    nextLevelList.add(right);
                    rooms[right.x][right.y] = step + 1;
                    visited[right.x][right.y] = true;

                }

                if (top.y >= 0 && !visited[top.x][top.y] && rooms[top.x][top.y] != -1) {
                    nextLevelList.add(top);
                    rooms[top.x][top.y] = step + 1;
                    visited[top.x][top.y] = true;

                }

                if (bottom.y < rooms[0].length && !visited[bottom.x][bottom.y] && rooms[bottom.x][bottom.y] != -1) {
                    nextLevelList.add(bottom);
                    rooms[bottom.x][bottom.y] = step + 1;
                    visited[bottom.x][bottom.y] = true;
                }
            }
            levelList = nextLevelList;
            step++;
        }

        return;
    }

    public static void main(String[] args) {
        FaceBook_WallAndGates p = new FaceBook_WallAndGates();
        int[][] a = {{3, -1, 0, 1}, {2, 2, 1, -1}, {1, -1, 2, -1}, {0, -1, 3, 4}};
        p.wallsAndGates(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
