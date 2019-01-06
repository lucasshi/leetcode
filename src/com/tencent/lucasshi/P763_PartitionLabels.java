package com.tencent.lucasshi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class P763_PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i--) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        ArrayList<int[]> intervals = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int[] mergeInterval = null;
        int[] interval = new int[2];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            // do
            interval[0] = i;
            interval[1] = lastIndex[S.charAt(i) - 'a'];
            if (mergeInterval == null) {
                mergeInterval = new int[]{interval[0], interval[1]};
            } else if (interval[0] <= mergeInterval[1]) {
                mergeInterval[1] = Math.max(interval[1], mergeInterval[1]);
            } else {
                intervals.add(mergeInterval);
                result.add(mergeInterval[1] - mergeInterval[0] + 1);
                mergeInterval = new int[]{interval[0], interval[1]};
            }
        }
        result.add(mergeInterval[1] - mergeInterval[0] + 1);
        return result;
    }
}
