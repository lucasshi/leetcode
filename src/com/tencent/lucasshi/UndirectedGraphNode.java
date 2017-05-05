package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/5/4.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
