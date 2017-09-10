package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by fzy on 17/9/4.
 */
public class Amazon_BuildWareHouse_done {
    static class Point {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 用最大堆
    public List<Point> buildWareHouse(List<Point> pointList, int N) {
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double distnaceO1 = Math.pow(o1.getX(), 2) + Math.pow(o1.getY(), 2);
                double distnaceO2 = Math.pow(o2.getX(), 2) + Math.pow(o2.getY(), 2);

                if (distnaceO1 == distnaceO2)
                    return 0;
                if (distnaceO1 > distnaceO2)
                    return -1;
                return 1;
            }
        });

        // point
        for (Point p : pointList) {
            priorityQueue.offer(p);
            if (priorityQueue.size() > N) {
                priorityQueue.poll();
            }
        }

        // set
        List<Point> result = new ArrayList<>();
        result.addAll(priorityQueue);

        return result;
    }

    public static void main(String[] args) {
        Amazon_BuildWareHouse_done buildWareHouse = new Amazon_BuildWareHouse_done();
        Point p1 = new Point(1, 8);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(5, 6);
        Point p4 = new Point(3, 3);
        Point p5 = new Point(10, 1);


        List<Point> pointList = new ArrayList<>();
        pointList.add(p1);
        pointList.add(p2);
        pointList.add(p3);
        pointList.add(p4);
        pointList.add(p5);


        List<Point> results = buildWareHouse.buildWareHouse(pointList, 4);
        System.out.println(results.size());
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).x + " " + results.get(i).y);
        }
    }
}
