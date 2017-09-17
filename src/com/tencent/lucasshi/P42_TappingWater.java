package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by fzy on 17/9/17.
 */
public class P42_TappingWater {
    public int trap(int[] height) {
        int maxHeight = 0;
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < height.length; i++) {
            maxHeight = Math.max(maxHeight, height[i]);
            minHeight = Math.min(minHeight, height[i]);
        }

        // do
        int totalTap = 0;
        minHeight = Math.max(1, minHeight);
        for (int i = minHeight; i <= maxHeight; i++) {
            ArrayList<Integer> nonZeroHeights = new ArrayList<>();
            boolean meetNonZero = false;
            int tmpTap = 0;
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= i && meetNonZero) {
                    totalTap += tmpTap;
                    tmpTap = 0;
                    continue;
                }

                if (height[j] >= i && !meetNonZero) {
                    meetNonZero = true;
                    continue;
                }

                tmpTap++;
            }
        }

        return totalTap;
    }
}
