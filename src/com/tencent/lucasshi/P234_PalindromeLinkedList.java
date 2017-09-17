package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/17.
 */
public class P234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //
        ListNode q = reverseLinkedList(slow);
        ListNode p = head;

        while (p != null && q != null) {
            if (p.val == q.val) {
                p = p.next;
                q = q.next;
                continue;
            }

            return false;
        }

        return true;
    }

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;


        ListNode p = head;
        ListNode q = head.next;
        ListNode t = head.next.next;

        while (q != null) {
            q.next = p;
            p = q;
            q = t;

            if (q != null) {
                t = q.next;
            }
        }

        head.next = null;

        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        P234_PalindromeLinkedList p = new P234_PalindromeLinkedList();
        System.out.println(p.isPalindrome(head));
    }
}
