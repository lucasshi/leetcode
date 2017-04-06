package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by fzy on 16/9/17.
 */
public class P7_ReverseInteger {
    public int[] reverse(int[] T) {
        // write your code in Java SE 8
        // make graph
        int capital = 0;
        ArrayList<Integer>[] graph = new ArrayList[T.length];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < T.length; i++) {
            int left = i;
            int right = T[i];

            graph[left].add(right);
            graph[right].add(left);

            if (left == right) {
                capital = left;
            }
        }

        int[] stepGraph = new int[T.length];
        for (int i = 0; i < stepGraph.length; i++){
            stepGraph[i] = 0;
        }
        boolean[] visted = new boolean[T.length];
        for (int i = 0; i < visted.length; i++) {
            visted[i] = false;
        }
        Queue<Integer> queue = new ArrayBlockingQueue<Integer>(T.length);
        queue.add(capital);
        visted[capital] = true;
        stepGraph[capital] = 0;
        // do bfs
        while (!queue.isEmpty()) {
            int count = 0;
            int val = queue.poll();
            for (int i = 0; i < graph[val].size(); i++) {
                int node = graph[val].get(i);
                if (!visted[node]) {
                    queue.add(node);
                    visted[node] = true;
                    stepGraph[node] = stepGraph[val] + 1;
                }
            }
        }

        int[] countGraph = new int[T.length];
        for (int i = 0; i < countGraph.length; i++) {
            countGraph[i] = 0;
        }

        for (int i = 0; i < stepGraph.length; i++) {
            int stepIndex = stepGraph[i];
            if (stepIndex > 0) {
                countGraph[stepIndex - 1] += 1;
            }
        }
        return countGraph;
    }

    public static void main(String[] args) {
        int[] sample = {9, 1, 4, 9, 0, 4, 8, 9, 0, 1};
        P7_ReverseInteger p7_reverseInteger = new P7_ReverseInteger();
        p7_reverseInteger.reverse(sample);

    }
}
