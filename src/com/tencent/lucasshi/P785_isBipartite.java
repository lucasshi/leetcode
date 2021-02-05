package com.tencent.lucasshi;

import java.util.*;

public class P785_isBipartite {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> leftPart = new HashSet<>();
        Set<Integer> rightPart = new HashSet<>();

        for (int i = 0; i < graph.length; i++) {
            if (!leftPart.contains(i) && !rightPart.contains(i)) {
                if (dfs(i, leftPart, rightPart, graph) == false)
                    return false;
            }
        }

        return true;
    }

    public boolean dfs(int node,
                       Set<Integer> valid,
                       Set<Integer> invalid,
                       int[][] graph) {
        if (invalid.contains(node))
            return false;

        if (valid.contains(node))
            return true;

        valid.add(node);
        for (int i = 0; i < graph[node].length; i++) {
            if(dfs(graph[node][i], invalid, valid, graph) == false)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] input = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        P785_isBipartite p785_isBipartite = new P785_isBipartite();
        System.out.println(p785_isBipartite.isBipartite(input));
    }
}
