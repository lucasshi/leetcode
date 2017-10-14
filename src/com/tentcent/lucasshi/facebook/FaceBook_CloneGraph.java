package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by fzy on 17/10/3.
 */
public class FaceBook_CloneGraph {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> pairs = new HashMap<>();
    UndirectedGraphNode result = new UndirectedGraphNode(node.label);
    Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();

    pairs.put(node, result);
    q.add(node);
    while (!q.isEmpty()) {
      UndirectedGraphNode oldNode = q.poll();
      UndirectedGraphNode newNode = pairs.get(oldNode);

      for (UndirectedGraphNode oldChildNode : oldNode.neighbors) {
        if (!pairs.containsKey(oldChildNode)) {
          pairs.put(oldChildNode, new UndirectedGraphNode(oldChildNode.label));
        }
        UndirectedGraphNode newChildNode = pairs.get(newNode);
        newNode.neighbors.add(newChildNode);

        q.offer(oldChildNode);
      }
    }

    return result;
  }
}
