package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/6.
 */
public class P141_hasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode pointer = head;
        ListNode fastPointer = head;

        while (pointer != null && fastPointer != null) {
            pointer = pointer.next;
            if (fastPointer.next == null) {
                break;
            }
            fastPointer = fastPointer.next.next;

            if (pointer == fastPointer) {
                return true;
            }
        }

        return false;
    }
}
