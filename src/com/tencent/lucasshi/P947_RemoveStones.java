package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P947_RemoveStones {
    private HashMap<Integer, Integer> union = new HashMap<>();

    public int removeStones(int[][] stones) {
        HashMap<Integer, List<Integer>> colConnection = new HashMap<>();
        HashMap<Integer, List<Integer>> rowConnection = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1];
            if (!rowConnection.containsKey(row))
                rowConnection.put(row, new ArrayList<>());
            if (!colConnection.containsKey(col))
                rowConnection.put(row, new ArrayList<>());
            rowConnection.get(row).add(i);
            colConnection.get(row).add(i);
            // do
            union.put(i, -1);
        }

        for (int i = 0; i < stones.length; i++) {
            for (Integer rindex : rowConnection.get(stones[i][0]))
                this.union(i, rindex);
            for (Integer cindex : colConnection.get(stones[i][1]))
                this.union(i, cindex);
        }

        int partCount = 0;
        for (Integer unionKey : union.keySet())
            if (union.get(unionKey) == -1)
                partCount += 1;
        return stones.length - partCount;
    }

    public int find(int j) {
        if (this.union.get(j) == -1)
            return j;
        return find(this.union.get(j));
    }

    public void union(int i, int j) {
        int rooti = this.union.get(i);
        int rootj = this.union.get(j);
        if (rooti != rootj)
            this.union.put(rootj, rooti);
    }
}
