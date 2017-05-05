package com.tencent.lucasshi;

import java.util.HashMap;

/**
 * Created by fzy on 17/5/4.
 */
public class P138_CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode cloneHead = new RandomListNode(head.label);
        RandomListNode p = head;
        RandomListNode cloneP = cloneHead;

        HashMap<RandomListNode, RandomListNode> visitedMap = new HashMap<>();
        visitedMap.put(head, cloneHead);

        // iterate
        while (p != null) {
            if (p.next != null) {
                RandomListNode nextNode = p.next;
                if (visitedMap.containsKey(nextNode)) {
                    cloneP.next = visitedMap.get(nextNode);
                } else {
                    RandomListNode cloneNext = new RandomListNode(nextNode.label);
                    cloneP.next = cloneNext;
                    visitedMap.put(nextNode, cloneNext);
                }
            } else {
                cloneP.next = null;
            }

            // random
            if (p.random != null) {
                RandomListNode randomNode = p.random;
                if (visitedMap.containsKey(randomNode)) {
                    cloneP.random = visitedMap.get(randomNode);
                } else {
                    RandomListNode cloneRandom = new RandomListNode(randomNode.label);
                    cloneP.random = cloneRandom;
                    visitedMap.put(randomNode, cloneRandom);
                }
            } else {
                cloneP.random = null;
            }

            p = p.next;
            cloneP = cloneP.next;
        }

        return cloneHead;
    }
}
