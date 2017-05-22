package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/21.
 */
public class P203_RemoveList {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode p = head;
        while (p.next != null && p != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            }

            p = p.next;
        }

        return head;
    }
}
