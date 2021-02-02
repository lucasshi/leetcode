package com.tencent.lucasshi;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class P1197_minKnightMoves {
    class Point {
        int x;
        int y;
        int step;

        public Point(int _x, int _y, int _step) {
            this.x = _x;
            this.y = _y;
            this.step = _step;
        }

        @Override
        public int hashCode() {
            return x * 1000000 + y;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return x == p.x && y == p.y;
        }

        public String  toString() {
            return x + " " + y  + " " + step + "\n";
        }
    }

    public int minKnightMoves(int x, int y) {
        int newX = Math.abs(x);
        int newY = Math.abs(y);

        int[][] directions = {{-1, -2}, {1, -2}, {2, -1}, {2, 1}
                , {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}};

        HashSet<Point> pointHashSet = new HashSet<>();

        Queue<Point> pointQueue = new LinkedList<>();
        pointQueue.add(new Point(0, 0, 0));
        pointHashSet.add(new Point(0, 0, 0));

        while (true) {
            Point point = pointQueue.poll();
            if (point.x == newX && point.y == newY)
                return point.step;

            for (int[] direction : directions) {
                Point nextPoint = new Point(point.x + direction[0], point.y + direction[1], point.step + 1);

                if (pointHashSet.contains(nextPoint)) {
                    continue;
                }

                pointQueue.add(nextPoint);
                pointHashSet.add(nextPoint);
            }
        }
    }
}
