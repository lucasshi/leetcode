package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.RandomListNode;

import java.util.HashMap;

/**
 * Created by fzy on 17/10/3.
 */
public class FaceBook_CopyList {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> pairs = new HashMap<>();

        RandomListNode newHead = new RandomListNode(head.label);
        pairs.put(head, newHead);

        RandomListNode p = head;
        while (p != null) {
            RandomListNode newP = pairs.get(p);
            //
            RandomListNode randomNode = p.random;
            RandomListNode nextNode = p.next;

            if (!pairs.containsKey(randomNode)) {
                pairs.put(randomNode, new RandomListNode(randomNode.label));
            }
            newP.random = pairs.get(randomNode);

            if (!pairs.containsKey(nextNode)) {
                pairs.put(nextNode, new RandomListNode(nextNode.label));
            }
            newP.next = pairs.get(nextNode);

            p = p.next;
        }

        return newHead;
    }
}
