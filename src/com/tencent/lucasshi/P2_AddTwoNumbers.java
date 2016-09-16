package com.tencent.lucasshi;

/**
 * Created by fzy on 16/9/12.
 */
public class P2_AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进位
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        ListNode ptr1 = null;
        int x = 0;
        int carry = 0;
        int sum = 0;

        while (l1 != null || l2 != null) {
            if (l1 == null && l2 != null) {
                sum = l2.val + 0 + carry;
                carry = sum / 10;
                x = sum % 10;
                ptr.val = x;
                ptr.next = new ListNode(0);
                ptr1 = ptr;
                ptr = ptr.next;
                l2 = l2.next;
            } else if (l2 == null && l1 != null) {
                sum = l1.val + 0 + carry;
                carry = sum / 10;
                x = sum % 10;
                ptr.val = x;
                ptr.next = new ListNode(0);
                ptr1 = ptr;
                ptr = ptr.next;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                carry = sum / 10;
                x = sum % 10;
                ptr.val = x;
                l1 = l1.next;
                l2 = l2.next;
                ptr1 = ptr;
                ptr.next = new ListNode(0);
                ptr = ptr.next;
            }
        }

        if (carry != 0) {
            ptr.val = carry;
            return result;
        } else {
            ptr1.next = null;
            return result;
        }
    }

}
