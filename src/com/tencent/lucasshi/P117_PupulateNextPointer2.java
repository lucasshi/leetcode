package com.tencent.lucasshi;

/**
 * Created by fzy on 17/4/30.
 */
public class P117_PupulateNextPointer2 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode prevHead = null;
        if (root == null) {
            return;
        }

        prevHead = root;
        prevHead.next = null;

        // level order
        while (prevHead != null) {
            TreeLinkNode pointer = prevHead;
            // 下一层的头结点
            TreeLinkNode nextPrevHead = null;
            // 下一层要连接的指针
            TreeLinkNode nextPoint = null;

            while (pointer != null) {
                // 找到需要便利的店
                while (pointer.left == null && pointer.right == null) {
                    pointer = pointer.next;
                }

                if (pointer == null) {
                    break;
                }

                // 找到了
                if (pointer.left == null) {
                    nextPrevHead = nextPrevHead == null ? pointer.right : nextPrevHead;
                    if (nextPoint != null) {
                        nextPoint.next = pointer.right;
                    }
                    nextPoint = pointer.right;
                } else if (pointer.right == null) {
                    nextPrevHead = nextPrevHead == null ? pointer.left : nextPrevHead;
                    if (nextPoint != null) {
                        nextPoint.next = pointer.left;
                    }
                    nextPoint = pointer.left;
                } else {
                    nextPrevHead = nextPrevHead == null ? pointer.left : nextPrevHead;
                    pointer.left.next = pointer.right;
                    if (nextPoint != null) {
                        nextPoint.next = pointer.left;
                        nextPoint = pointer.right;
                    } else {
                        nextPoint = pointer.right;
                    }
                }
                pointer = pointer.next;
            }

            if (nextPoint != null) {
                nextPoint.next = null;
            }
            prevHead = nextPrevHead;
        }
    }
}
