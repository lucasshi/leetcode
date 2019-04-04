package com.tencent.lucasshi;

import java.util.ArrayList;

public class P986_IntervalIntersecions {
    public ArrayList<Interval> intervalIntersection(Interval[] A, Interval[] B) {
        int aindex = 0;
        int bindex = 0;
        ArrayList<Interval> result = new ArrayList<>();
        // do
        while (aindex < A.length && bindex < B.length) {
            Interval a = A[aindex];
            Interval b = B[bindex];
            Interval intersect = getIntersectInterval(a, b);
            if (intersect != null) {
                result.add(intersect);
            }

            if (a.end < b.end) {
                aindex += 1;
            }
            if (b.end < a.end) {
                bindex += 1;
            } else {
                aindex += 1;
                bindex += 1;
            }
        }
        return result;
    }

    public Interval getIntersectInterval(Interval a, Interval b) {
        if (a.start <= b.end && a.start >= b.start)
            return new Interval(a.start, Math.min(a.end, b.end));
        if (b.start <= a.end && b.start >= a.end)
            return new Interval(b.start, Math.min(a.end, b.end));
        return null;
    }
}
