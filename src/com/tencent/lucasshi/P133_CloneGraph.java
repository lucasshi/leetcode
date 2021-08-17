package com.tencent.lucasshi;

import java.rmi.server.UnicastRemoteObject;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by fzy on 17/5/4.
 */
public class P133_CloneGraph {
    public static HashMap<UndirectedGraphNode, UndirectedGraphNode> isVisitedMap = new HashMap<>();

    public UndirectedGraphNode cloneGraphV1(UndirectedGraphNode node) {
        if (isVisitedMap.containsKey(node))
            return isVisitedMap.get(node);
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);

        for (UndirectedGraphNode neighborNode: node.neighbors) {
            cloneNode.neighbors.add(cloneGraphV1(neighborNode));
        }

        return cloneNode;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> cloneQ = new LinkedList<UndirectedGraphNode>();

        if (node == null) {
            return null;
        }

        UndirectedGraphNode resultNode = new UndirectedGraphNode(node.label);
        q.offer(node);
        cloneQ.offer(resultNode);
        isVisitedMap.put(node, resultNode);

        // 层次便利
        while (!q.isEmpty()) {
            UndirectedGraphNode sourceNode = q.poll();
            UndirectedGraphNode destNode = cloneQ.poll();

            for (int i = 0; i < sourceNode.neighbors.size(); i++) {
                UndirectedGraphNode neighborNode = sourceNode.neighbors.get(i);
                if (isVisitedMap.containsKey(neighborNode)) {
                    destNode.neighbors.add(isVisitedMap.get(neighborNode));
                    continue;
                }

                UndirectedGraphNode cloneNeighbor = new UndirectedGraphNode(neighborNode.label);
                destNode.neighbors.add(cloneNeighbor);
                // 放到队列中去BFS
                q.offer(neighborNode);
                cloneQ.offer(cloneNeighbor);
                isVisitedMap.put(neighborNode, cloneNeighbor);
            }
        }

        return resultNode;
    }


}
