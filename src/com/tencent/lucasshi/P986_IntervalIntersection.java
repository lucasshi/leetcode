package com.tencent.lucasshi;

import java.util.ArrayList;

public class P986_IntervalIntersection {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        int Aindex = 0;
        int Bindex = 0;

        // do
        ArrayList<Interval> result = new ArrayList<>();
        while (Aindex < A.length && Bindex < B.length) {
            Interval AInterval = A[Aindex];
            Interval BInterval = B[Bindex];
            Interval intersect = getIntersect(AInterval, BInterval);
            //
            if (intersect != null) {
                result.add(intersect);
            }
            if (AInterval.end < BInterval.end) {
                Aindex += 1;
            } else if (AInterval.end > BInterval.end) {
                Bindex += 1;
            } else {
                Aindex += 1;
                Bindex += 1;
            }
        }

        return result.toArray(new Interval[result.size()]);
    }

    public Interval getIntersect(Interval a, Interval b) {
        if (a.end < b.start || b.end < a.start)
            return null;
        return new Interval(Math.max(a.start, b.start), Math.min(a.end, b.end));
    }
}
