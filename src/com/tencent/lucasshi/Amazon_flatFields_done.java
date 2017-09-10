package com.tencent.lucasshi;

import java.util.*;

/**
 * Created by fzy on 17/9/4.
 */
public class Amazon_flatFields_done {
    class Point {
        public int x;
        public int y;
        public int value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public int flatFields(int numRows, int numColumns, List<List<Integer>> fields) {
        int[][] maze = new int[numRows][numColumns];
        PriorityQueue<Point> points = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.value - o2.value;
            }
        });


        // priorityQueue
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                int val = fields.get(i).get(j);
                maze[i][j] = val;

                if (val > 1) {
                    Point p = new Point(i, j, val);
                    points.add(p);
                }
            }
        }

        // 四个方向
        int sumStep = 0;
        ArrayList<Integer> firstSteps = new ArrayList<>();
        Point startPoint = new Point(0, 0, maze[0][0]);
        Point firstPoint = points.poll();

        firstSteps.add(getStep(maze, startPoint, firstPoint));
        startPoint = new Point(numRows - 1, numColumns - 1, maze[numRows - 1][numColumns - 1]);
        firstSteps.add(getStep(maze, startPoint, firstPoint));

        startPoint = new Point(0, numColumns - 1, maze[0][numColumns - 1]);
        firstSteps.add(getStep(maze, startPoint, firstPoint));

        startPoint = new Point(numRows - 1, 0, maze[numRows - 1][0]);
        firstSteps.add(getStep(maze, startPoint, firstPoint));

        int firstStep = Integer.MAX_VALUE;
        boolean allInvalid = true;
        for (int i = 0; i < firstSteps.size(); i++) {
            if (firstSteps.get(i) == -1)
                continue;
            firstStep = Math.min(firstStep, firstSteps.get(i));
            allInvalid = false;
        }

        if (allInvalid)
            return -1;

        sumStep = firstStep;
        // 开始重新看
        startPoint = firstPoint;
        while (!points.isEmpty()) {
            Point endPoint = points.poll();
            int step = getStep(maze, startPoint, endPoint);
            if (step == -1) {
                return -1;
            }

            sumStep += step;
            startPoint = endPoint;
            maze[endPoint.x][endPoint.y] = 1;
        }

        return sumStep;
    }

    public int getStep(int[][] maze, Point startPoint, Point endPoint) {
        int height = maze.length;
        int width = maze[0].length;
        boolean[][] visited = new boolean[height][width];

        if (maze[startPoint.x][startPoint.y] != 1)
            return -1;
        int step = 0;
        ArrayList<Point> currentPoints = new ArrayList<>();
        currentPoints.add(startPoint);
        visited[startPoint.x][startPoint.y] = true;

        while (!currentPoints.isEmpty()) {
            ArrayList<Point> nextPoints = new ArrayList<>();
            for (Point p : currentPoints) {
                // 找到了
                if (p.x == endPoint.x && p.y == endPoint.y) {
                    return step;
                }

                int x = p.x;
                int y = p.y;

                if (x - 1 > 0 && !visited[x - 1][y] && maze[x - 1][y] != 0) {
                    nextPoints.add(new Point(x - 1, y, 0));
                    visited[x - 1][y] = true;
                }

                if (y - 1 > 0 && !visited[x][y - 1] && maze[x][y - 1] != 0) {
                    nextPoints.add(new Point(x, y - 1, 0));
                    visited[x][y - 1] = true;
                }

                if (x + 1 < height && !visited[x + 1][y] && maze[x + 1][y] != 0) {
                    nextPoints.add(new Point(x + 1, y, 0));
                    visited[x + 1][y] = true;
                }

                if (x + 1 < height && !visited[x][y + 1] && maze[x][y + 1] != 0) {
                    nextPoints.add(new Point(x, y + 1, 0));
                    visited[x][y + 1] = true;
                }
            }
            currentPoints = nextPoints;
            step++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Amazon_flatFields_done amazon_flatFields = new Amazon_flatFields_done();
        ArrayList<List<Integer>> mazeList = new ArrayList<>();
        mazeList.add(Arrays.asList(1, 4, 0, 2));
        mazeList.add(Arrays.asList(1, 1, 3, 1));


        System.out.println(amazon_flatFields.flatFields(2, 4, mazeList));

    }


}
