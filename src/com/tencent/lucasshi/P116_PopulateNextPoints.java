package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/30.
 */
public class P116_PopulateNextPoints {
    public void connect(TreeLinkNode root) {
        TreeLinkNode prevHead = null;

        if (root == null) {
            return;
        }

        prevHead = root;
        prevHead.next = null;

        // level order
        while (prevHead != null)  {
            TreeLinkNode pointer = prevHead;
            while (pointer.next != null) {
                if (pointer.left !=null) {
                    pointer.left.next = pointer.right;
                    pointer.right.next = pointer.next.left;
                }
                pointer = pointer.next;
            }

            if (pointer.left != null) {
                pointer.left.next = pointer.right;
                pointer.right.next = null;
            }

            prevHead = prevHead.left;
        }
    }
}
