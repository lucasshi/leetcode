package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P846_isNStraightHand {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> cnts = new TreeMap<>();
        if (hand.length % W != 0)
            return false;

        for (int i = 0; i < hand.length; i++) {
            cnts.putIfAbsent(hand[i], 0);
            cnts.put(hand[i], cnts.get(hand[i]) + 1);
        }

        while (!cnts.isEmpty()) {
            if (check(cnts, W) == false)
                return false;
        }

        return true;
    }

    public boolean check(TreeMap<Integer, Integer> cnts, int W) {
        // int min = cnts.entrySet().stream().mapToInt(entry -> entry.getKey()).min().getAsInt();
        int min = cnts.firstKey();
        int minCnt = cnts.get(min);

        for (int i = 0; i < W; i++) {
            if (!cnts.containsKey(min + i) || cnts.get(min + i) < minCnt)
                return false;
            cnts.put(min + i, cnts.get(min + i) - minCnt);
            if (cnts.get(min + i) == 0)
                cnts.remove(min + i);
        }
        return true;
    }
}
