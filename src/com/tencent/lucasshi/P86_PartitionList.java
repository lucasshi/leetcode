package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/29.
 */
public class P86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = null;
        ListNode largeHead = null;
        ListNode pSmall = null;
        ListNode pLarge = null;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                if (smallHead == null) {
                    smallHead = new ListNode(p.val);
                    pSmall = smallHead;
                } else {
                    pSmall.next = new ListNode(p.val);
                    pSmall = pSmall.next;
                }
            } else {
                if (largeHead == null) {
                    largeHead = new ListNode(p.val);
                    pLarge = largeHead;
                } else {
                    pLarge.next = new ListNode(p.val);
                    pLarge = pLarge.next;
                }
            }

            p = p.next;
        }

        if (largeHead == null) {
            return smallHead;
        } else if (smallHead == null) {
            return largeHead;
        } else {
            pSmall.next = largeHead;
        }

        return pSmall;
    }
}
