package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/10.
 */
public class P234_PalindromeLinked {
    public boolean isPalindrome(ListNode head) {
        ListNode middleP = head;
        ListNode twiceP = head;

        while (twiceP.next == null && twiceP != null) {
            middleP = middleP.next;
            twiceP = twiceP.next.next;
        }


        return false;
    }
}
