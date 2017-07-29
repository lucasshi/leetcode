package com.tencent.lucasshi;

import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * Created by fzy on 17/7/29.
 */
public class P236_LCA {
    class TreeListNode {
        TreeNode node;
        TreeListNode next;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeListNode pPath = getPath(root, p);
        TreeListNode qPath = getPath(root, q);

        TreeNode lcaNode = pPath.node;
        while (true) {
            if (qPath != null && pPath != null && qPath.node == pPath.node) {
                lcaNode = qPath.node;
                qPath = qPath.next;
                pPath = pPath.next;
            } else {
                break;
            }
        }

        return lcaNode;
    }

    public TreeListNode getPath(TreeNode root, TreeNode target) {
        if (root == target) {
            TreeListNode tail = new TreeListNode();
            tail.node = root;
            return tail;
        }

        if (root == null) {
            return null;
        }

        TreeListNode leftNode = getPath(root.left, target);
        if (leftNode != null) {
            TreeListNode p = new TreeListNode();
            p.node = root;
            p.next = leftNode;
            return p;
        }

        TreeListNode rightNode = getPath(root.right, target);
        if (rightNode != null) {
            TreeListNode p = new TreeListNode();
            p.node = root;
            p.next = rightNode;
            return p;
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(1);

        p1.right = p2;
        P236_LCA lca = new P236_LCA();
        System.out.println(lca.lowestCommonAncestor(p2, p1, p2));
    }
}
