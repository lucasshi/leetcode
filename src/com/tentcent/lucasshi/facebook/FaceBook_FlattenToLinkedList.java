package com.tentcent.lucasshi.facebook;

import com.apple.eawt.AppEvent;
import com.tencent.lucasshi.TreeNode;

/**
 * Created by fzy on 17/10/15.
 */
public class FaceBook_FlattenToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode p = root;

        while (p != null) {
            if (p.left != null) {
                TreeNode t = p.left;
                while (t.right != null)
                    t = t.right;
                t.right = p.right;
                p.right = p.left;
                p.left = null;
            }

            p = p.right;
        }
    }

    public TreeNode flatten2(TreeNode root) {
        TreeNode head = root;
        TreeNode p = root;
        TreeNode prevp = null;

        while (head.left != null)
            head = head.left;

        while (p != null) {
            if (p.left != null) {
                TreeNode pLeft = p.left;
                TreeNode t = pLeft;
                while (t.right != null)
                    t = t.right;
                t.right = p;
                p.left = null;
                if (prevp != null) {
                    prevp.right = pLeft;
                }
                p = pLeft;
            } else {
                prevp = p;
                p = p.right;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(11);
        root.right.right.left = new TreeNode(10);

        FaceBook_FlattenToLinkedList p = new FaceBook_FlattenToLinkedList();
        TreeNode v2 = p.flatten2(root);


        while (v2 != null) {
            System.out.println(v2.val);
            v2 = v2.right;
        }
    }
}
