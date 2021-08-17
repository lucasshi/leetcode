package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by fzy on 17/4/23.
 */
public class P57_InserInterval {
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

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Interval newInter = newInterval;
        List<Interval> result = new ArrayList<>();

        for (Interval inter : intervals) {
            if (newInter.start > inter.end || newInter.end < inter.start) {
                result.add(inter);
                continue;
            }

            int start = Math.min(newInter.start, inter.start);
            int end = Math.max(newInter.end, inter.end);

            newInter.start = start;
            newInter.end = end;
        }

        result.add(newInter);
        result.sort((o1, o2) -> o1.start == o2.start ? 0 : o1.start - o2.start);
        return result;
    }
}
