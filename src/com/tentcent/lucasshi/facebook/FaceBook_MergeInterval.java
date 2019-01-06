package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by fzy on 17/10/14.
 */
public class FaceBook_MergeInterval {
    public List<Interval> merge(Interval v1, Interval v2) {
        if (v1.start <= v2.end || v2.start <= v1.end) {
            Interval interval = new Interval(
                    Math.min(v1.start, v2.start), Math.max(v1.end, v2.end));
            return null;
        }
        return null;
    }

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> result = new ArrayList<>();
        Interval mergeInterval = null;
        for (int i = 0; i < intervals.size(); i++) {
            if (mergeInterval == null) {
                mergeInterval = intervals.get(i);
                continue;
            }

            // do
            Interval interval = intervals.get(i);
            if (interval.start <= mergeInterval.end) {
                mergeInterval.end = Math.max(mergeInterval.end, interval.end);
                mergeInterval.start = Math.min(mergeInterval.start, interval.start);
                continue;
            } else {
                result.add(mergeInterval);
                mergeInterval = interval;
            }
        }

        result.add(mergeInterval);
        return result;
    }

    public static void main(String[] args) {

    }
}
