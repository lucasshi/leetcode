package com.tentcent.lucasshi.facebook;

import java.util.*;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_IsBiparite {
    public boolean isBipartite(int[][] G) {
        int[] colors = new int[G.length];

        colors[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int src = queue.poll();
            for (int i = 0; i < G.length; i++) {
                if (G[src][i] == 1) {
                    int destColor = -1 * colors[src];
                    if (colors[i] == 0) {
                        colors[i] = destColor;
                    } else if (colors[i] == destColor) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
