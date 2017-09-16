package com.tencent.lucasshi;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by fzy on 17/9/16.
 */
public class P453_MinArrows {
    class Pair {
        public int start;
        public int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int findMinArrowShots(int[][] points) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];
            pairs.add(new Pair(start, end));
        }

        // 排序
        pairs.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.start == o2.start)
                    return o1.end < o2.end ? -1 : 1;
                return o1.start < o2.start ? -1 : 1;
            }
        });

        int startIndex = 0;
        int endIndex = 1;
        if (pairs.size() <= 1) {
            return pairs.size();
        }


        for (int i = 0; i < pairs.size(); i++) {
            System.out.println(pairs.get(i).start + " " + pairs.get(i).end);
        }
        int count = 0;
        while (endIndex <= pairs.size()) {
            Pair startPair = pairs.get(startIndex);
            for (; endIndex < pairs.size(); endIndex++) {
                Pair endPair = pairs.get(endIndex);
                if (endPair.start > startPair.end) {
                    break;
                }
                startPair.end = Math.min(pairs.get(endIndex).end,
                        startPair.end);

            }

            count++;
            startIndex = endIndex;
            endIndex++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] input1 = {{3, 9}, {7, 12}, {3, 8}, {6, 8},
                {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};

        int[][] input2 =
                {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};

        P453_MinArrows p = new P453_MinArrows();
        p.findMinArrowShots(input1);
        p.findMinArrowShots(input2);

    }
}

