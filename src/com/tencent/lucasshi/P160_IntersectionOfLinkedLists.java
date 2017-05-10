package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/7.
 */
public class P160_IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        int lengthA = 1;
        int lengthB = 1;

        if (pA == null || pB == null) {
            return null;
        }
        //
        if (pA == pB) {
            return pA;
        }

        while (pA.next != null) {
            pA = pA.next;
            lengthA += 1;
        }

        while (pB.next != null) {
            pB = pB.next;
            lengthB += 1;
        }

        // 没找到
        if (pA != pB || pA == null) {
            return null;
        }

        int stepOver = Math.abs(lengthA - lengthB);
        pA = headA;
        pB = headB;
        if (lengthA > lengthB) {
            for (int i = 0; i < stepOver; i++) {
                pA = pA.next;
            }
        } else {
            for (int i = 0; i < stepOver; i++) {
                pB = pB.next;
            }
        }

        while (pA!=null && pB !=null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
}
