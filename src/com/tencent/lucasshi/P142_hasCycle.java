package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/6.
 */
public class P142_hasCycle {
    public ListNode hasCycle(ListNode head) {
        ListNode pointer = head;
        ListNode fastPointer = head;

        if (head == null)
            return null;
        while (pointer != null && fastPointer != null) {
            pointer = pointer.next;
            if (fastPointer.next == null || fastPointer.next.next == null) {
                return null;
            }
            fastPointer = fastPointer.next.next;

            if (pointer == fastPointer) {
                break;
            }
        }

        // youle
        ListNode slowNode = head;
        while (slowNode != pointer) {
            slowNode = slowNode.next;
            pointer = pointer.next;
        }

        return slowNode;
    }
}
