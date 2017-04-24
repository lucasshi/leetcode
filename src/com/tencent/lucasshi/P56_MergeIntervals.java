package com.tencent.lucasshi;

import java.util.ArrayList;
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
