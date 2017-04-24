package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/24.
 */
public class P61_RotateList {
    ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 0;
        ListNode ptr = head;
        ListNode tail = head;
        while (ptr != null) {
            length++;
            tail = ptr;
            ptr = ptr.next;
        }
        k %= length;

        ptr = head;
        for (int i = 0; i < length - k - 1; i++) {
            ptr = ptr.next;
        }

        tail.next = head;
        head = ptr.next;
        ptr.next = null;

        return head;
    }
}
