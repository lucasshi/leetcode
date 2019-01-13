package com.tencent.lucasshi;

import java.util.*;

public class P261_validTree {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> hashEdges = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < edges.length; i++) {
            if (!hashEdges.containsKey(edges[i][0]))
                hashEdges.put(edges[i][0], new ArrayList<>());
            if (!hashEdges.containsKey(edges[i][1]))
                hashEdges.put(edges[i][1], new ArrayList<>());
            hashEdges.get(edges[i][0]).add(edges[i][1]);
            hashEdges.get(edges[i][1]).add(edges[i][0]);
        }

        int sum = helper(hashEdges, visited, -1, 0);
        return sum == n;
    }

    public int helper(HashMap<Integer, ArrayList<Integer>> hashEdges,
            HashSet<Integer> visisted, int prev, int curr) {
        if (visisted.contains(curr))
            return -1;
        if (!hashEdges.containsKey(curr))
            return 1;
        // do
        visisted.add(curr);
        int sum = 1;
        for (int connectNode : hashEdges.get(curr)) {
            if (connectNode == prev)
                continue;
            int nodeCount = helper(hashEdges, visisted, curr, connectNode);
            if (nodeCount == -1)
                return -1;
            sum += nodeCount;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
