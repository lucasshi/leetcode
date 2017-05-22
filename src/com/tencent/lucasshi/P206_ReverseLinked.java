package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/21.
 */
public class P206_ReverseLinked {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode nextHead = reverseList(head.next);
        ListNode p = nextHead;
        while (p.next != null) {
            p = p.next;
        }

        p.next = head;
        head.next = null;

        return nextHead;
    }

    public static void main(String args) {

    }
}
