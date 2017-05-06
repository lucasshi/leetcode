package com.tencent.lucasshi;

/**
 * Created by fzy on 17/5/6.
 */
public class P148_SortList {
    public ListNode sortList(ListNode head) {
        ListNode smallLists = null;
        ListNode bigLists = null;
        ListNode smallp = smallLists;
        ListNode bigp = bigLists;

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode p = head.next;
        ListNode cp = head;
        while (p != null) {
            if (p.val < head.val) {
                if (smallLists == null) {
                    smallLists = p;
                    smallp = p;
                } else {
                    smallp.next = p;
                    smallp = smallp.next;
                }
            } else if (p.val > head.val) {
                if (bigLists == null) {
                    bigLists = p;
                    bigp = p;
                } else {
                    bigp.next = p;
                    bigp = bigp.next;
                }
            } else { // == 用来减少时间
                cp.next = p;
                cp = cp.next;
            }

            p = p.next;
        }

        if (smallp != null) {
            smallp.next = null;
        }

        if (bigp != null) {
            bigp.next = null;
        }


        ListNode smallHead = sortList(smallLists);
        ListNode bigHead = sortList(bigLists);


        smallp = smallHead;
        while (smallp != null && smallp.next != null) {
            smallp = smallp.next;
        }

        if (smallp != null) {
            smallp.next = head;
        } else {
            smallHead = head;
        }

        cp.next = bigHead;
        return smallHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);


        P148_SortList p = new P148_SortList();
        ListNode newHead = p.sortList(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
