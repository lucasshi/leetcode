package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/6.
 */
public class P143_ReorderList {
    public void reorderList(ListNode head) {
        ListNode pointer = head;
        ListNode fastPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            pointer = pointer.next;
        }

        ListNode rightHead = pointer.next;
        pointer.next = null;

        // 现在就是revert下面的节点
        ListNode p = rightHead;
        ListNode q = rightHead.next;
        if (q != null) {
            ListNode t = rightHead.next.next;
            p.next = null;
            if (t == null) {
                q.next = p;
                p = q;
            } else {
                while (p != null && q != null) {
                    q.next = p;
                    p = q;
                    q = t;
                    if (t != null) {
                        t = t.next;
                    }
                }
            }
        }

        // 现在右边已经revert好了, 开始进行处理
        ListNode lPointer = head;
        ListNode rPointer = p;
        while (lPointer != null && rPointer != null) {
            ListNode rNext = rPointer.next;
            ListNode lNext = lPointer.next;
            // do
            rPointer.next = lPointer.next;
            lPointer.next = rPointer;
            rPointer = rNext;
            lPointer = lNext;
        }

        System.out.println(head.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);
        //head.next.next.next.next.next.next = new ListNode(7);



        P143_ReorderList p = new P143_ReorderList();
        p.reorderList(head);
    }
}
