package com.tencent.lucasshi;

import java.util.HashSet;
import java.util.Set;

public class P547_findCircleNum {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                dfs(visited, i, isConnected);
                result += 1;
            }
        }
        return result;
    }

    void dfs(Set<Integer> visited, int index, int[][] isConnected) {
        if (visited.contains(index)) {
            return;
        }

        visited.add(index);
        for (int i = 0; i < isConnected[index].length; i++) {
            if (isConnected[index][i] == 1) {
                dfs(visited, i, isConnected);
            }
        }
    }
}
