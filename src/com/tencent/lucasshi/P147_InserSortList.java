package com.tencent.lucasshi;

import java.util.List;

/**
 * Created by fzy on 17/5/6.
 */
public class P147_InserSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode q = head;
            ListNode prevQ = null;
            while (q != null && q.val <= p.val) {
                prevQ = q;
                q = q.next;
            }

            ListNode processNode = p;
            p = p.next;

            if (q == head) {
                processNode.next = head;
                head = processNode;
            } else {
                processNode.next = prevQ.next;
                prevQ.next = processNode;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);


        P147_InserSortList p = new P147_InserSortList();
        ListNode newHead = p.insertionSortList(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
