package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

public class P1762_findBuildings {
    public int[] findBuildings(int[] heights) {
        List<Integer> buildings = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max)
                buildings.add(i);
            max = Math.max(heights[i], max);
        }

        int[] result = new int[buildings.size()];
        for (int i = 0; i < buildings.size(); i++)
            result[i] = buildings.get(buildings.size() - 1 - i);
        return result;
    }

    public static void main(String[] args) {
        P1762_findBuildings p1762_findBuildings = new P1762_findBuildings();
        p1762_findBuildings.findBuildings(new int[] {4, 2, 3, 1});
    }
}
