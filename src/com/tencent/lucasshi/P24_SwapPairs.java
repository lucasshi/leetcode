package com.tencent.lucasshi;

/**
 * Created by fzy on 17/3/27.
 */

public class P24_SwapPairs {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null) {
            // do swap
            int tmpVal = p1.val;
            p1.val = p2.val;
            p2.val = tmpVal;

            p1 = p2.next;
            if (p1 == null) {
                break;
            }

            p2 = p1.next;
        }

        return head;
    }

}
