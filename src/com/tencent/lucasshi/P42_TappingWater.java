package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by fzy on 17/9/17.
 */
public class P42_TappingWater {
    public int tappingWater(int[] height) {
        int[] lHigh = new int[height.length];
        int[] rHigh = new int[height.length];

        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            lHigh[i] = maxHeight;
            maxHeight = Math.max(height[i], maxHeight);
        }

        maxHeight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rHigh[i] = maxHeight;
            maxHeight = Math.max(height[i], maxHeight);
        }

        int total = 0;
        for (int i = 0; i < height.length; i++) {
            if (lHigh[i] < height[i] || rHigh[i] < height[i])
                continue;
            total += Math.min(lHigh[i], rHigh[i]) - height[i];
        }
        return total;
    }

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
