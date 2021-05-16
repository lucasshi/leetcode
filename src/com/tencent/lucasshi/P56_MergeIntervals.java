package com.tencent.lucasshi;

import sun.jvm.hotspot.LinuxVtblAccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by fzy on 17/4/23.
 */
public class P56_MergeIntervals {
    class Interval {
        public int start;
        public int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

    }

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0]? 0 : o1[0] - o2[0]);

        int[] merged = Arrays.copyOf(intervals[0], intervals[0].length);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= merged[1]) {
                merged[1] = Math.max(merged[1], intervals[i][1]);
            } else {
                res.add(merged);
                merged = Arrays.copyOf(intervals[i], intervals[i].length);
            }
        }

        res.add(merged);
        return res.toArray(new int[res.size()][]);
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start == o2.start ? 0 : o1.start - o2.start;
            }
        });
        Interval merged = null;
        for (Interval interval : intervals) {
            if (merged == null) {
                merged = interval;
                continue;
            }

            //  存在交集的情况
            if (!(merged.start > interval.end || merged.end < interval.start)) {
                int start = Math.min(merged.start, interval.start);
                int end = Math.max(merged.end, interval.end);
                merged.start = start;
                merged.end = end;
                continue;
            }

            // 不存在交集的情况
            result.add(merged);
            merged = interval;
        }

        if (merged != null) {
            result.add(merged);
        }
        return result;
    }
}
