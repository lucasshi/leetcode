package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/21.
 */
public class P237_DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
