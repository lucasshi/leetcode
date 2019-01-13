package com.tencent.lucasshi;

import java.util.HashMap;
import java.util.HashSet;

public class P403_FrogJump {
    public boolean canCross(int[] stones) {
        HashSet<Integer> stoneMap = new HashSet<>();
        HashSet<String> visitedIndex = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            stoneMap.add(stones[i]);
        }

        visitedIndex.add(stones[0] + "," + 0);
        for (int k = 0; k < stones.length; k++) {
            for (int j = 0; j < stones.length; j++) {
                int i = stones[k];
                if (i < j) {
                    break;
                } else if (j - 1 >= 0 && visitedIndex.contains((i - j) + "," + (j - 1))) {
                    visitedIndex.add(i + "," + j);
                } else if (visitedIndex.contains((i - j) + "," + j)) {
                    visitedIndex.add(i + "," + j);
                } else if (visitedIndex.contains((i - j) + "," + (j + 1))) {
                    visitedIndex.add(i + "," + j);
                }
            }
        }

        int lastStone = stones[stones.length - 1];
        for (String vs : visitedIndex) {
            System.out.println(vs);
        }
        for (int i = 0; i < stones.length; i++)
            if (visitedIndex.contains(lastStone + "," + i))
                return true;
        return false;
    }


    public static void main(String[] args) {
        P403_FrogJump p = new P403_FrogJump();
        int[] stones = new int[]{0, 1, 3, 4, 5, 7, 9, 10, 12};
        System.out.println(p.canCross(stones));
    }
}