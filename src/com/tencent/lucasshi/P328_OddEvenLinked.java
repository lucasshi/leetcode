package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/17.
 */
public class P328_OddEvenLinked {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode oddp = null;
        ListNode evenp = null;
        ListNode evenHead = null;
        ListNode oddHead = null;
        ListNode p = head;

        while (p != null) {
            if (p.val % 2 == 0) {
                if (evenp == null) {
                    evenp = p;
                    evenHead = p;
                } else {
                    evenp.next = p;
                    evenp = p;
                }
            } else {
                if (oddp == null) {
                    oddp = p;
                    oddHead = p;
                } else {
                    oddp.next = p;
                    oddp = p;
                }
            }

            p = p.next;
        }

        if (head.val % 2 == 0) {
            evenp.next = oddHead;
            if (oddp != null)
                oddp.next = null;
        } else {
            oddp.next = evenHead;
            if (evenp != null)
                evenp.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);


        P328_OddEvenLinked p = new P328_OddEvenLinked();
        p.oddEvenList(head);
        ListNode pNode = head;

        while (pNode != null) {
            System.out.println(pNode.val);
            pNode = pNode.next;
        }
    }
}
