package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by fzy on 17/9/16.
 */
public class P253_MeetingRoom2 {
    private static final int POINT_TYPE_START = 2;
    private static final int POINT_TYPE_END = 1;

    class TimePoint {
        public int val;
        public int pointType;

        TimePoint(int val, int pointType) {
            this.val = val;
            this.pointType = pointType;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        List<TimePoint> timePoints = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i].start;
            int end = intervals[i].end;

            timePoints.add(new TimePoint(start, POINT_TYPE_START));
            timePoints.add(new TimePoint(end, POINT_TYPE_END));
        }

        timePoints.sort(new Comparator<TimePoint>() {
            @Override
            public int compare(TimePoint o1, TimePoint o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val > o2.val) {
                    return 1;
                }

                return o1.pointType - o2.pointType;
            }
        });

        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < timePoints.size(); i++) {
            if (timePoints.get(i).pointType == POINT_TYPE_START) {
                count++;
            } else {
                count--;
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }


}
