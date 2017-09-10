package com.tencent.lucasshi;

import java.util.ArrayList;

/**
 * Created by fzy on 17/9/3.
 */
public class Amazon_Maze_done {
    class Point {
        public int x;
        public int y;
    }

    public int uniquePathsWithObstacles(int[][] maze) {
        int height = maze.length;
        int width = maze[0].length;

        ArrayList<Point> q = new ArrayList<>();
        boolean[][] visted = new boolean[height][width];

        // do
        Point first = new Point();
        first.x = 0;
        first.y = 0;

        q.add(first);

        int step = 0;
        while (!q.isEmpty()) {
            ArrayList<Point> nextQ = new ArrayList<>();
            //
            for (int i = 0; i < q.size(); i++) {
                Point p = q.get(i);
                int x = p.x;
                int y = p.y;

                if (x == width - 1 && y == height - 1)
                    return step;
                // right
                if (x + 1 < height && !visted[x + 1][y] && maze[x + 1][y] == 0) {
                    Point nextp = new Point();
                    nextp.x = x + 1;
                    nextp.y = y;
                    nextQ.add(nextp);
                }

                if (y + 1 < width && !visted[x][y + 1] && maze[x][y + 1] == 0) {
                    Point nextp = new Point();
                    nextp.x = x;
                    nextp.y = y + 1;
                    nextQ.add(nextp);
                }
            }

            q = nextQ;
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] maze = {{0, 0, 0}, {0, 1, 0}, {0, 1, 0}};
        Amazon_Maze_done amazon_maze_done = new Amazon_Maze_done();
        System.out.println(amazon_maze_done.uniquePathsWithObstacles(maze));
    }

}
