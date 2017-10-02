package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/9/22.
 */
public class Airbnb_MeetingRooms {
    public void MeeingRooms(List<Interval> intervals) {
        List<Interval> intervalList = new ArrayList<>();
        Interval mergeInterval = null;

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (mergeInterval == null) {
                mergeInterval = interval;
                continue;
            }

            if (interval.start <= mergeInterval.end) {
                mergeInterval.start = Math.min(mergeInterval.start,
                        interval.start);
                mergeInterval.end = Math.max(mergeInterval.end,
                        interval.end);
                continue;
            }

            intervalList.add(mergeInterval);
            mergeInterval = null;
        }

        if (mergeInterval != null) {
            intervalList.add(mergeInterval);
        }

        // print interval

    }
}
