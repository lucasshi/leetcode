package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created by fzy on 17/10/12.
 */
public class FaceBook_PostOrder {
    HashSet<TreeNode> rightVisited = new HashSet<>();
    public void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode p = root;

        while (!stack.empty()) {
            if (p.left != null) {
                p = p.left;
                stack.push(p);
                continue;
            }

            while (!stack.empty()) {
                p = stack.peek();
                if (!rightVisited.contains(p)) {
                    rightVisited.add(p);
                    if (p.right != null) {
                        p = p.right;
                        stack.push(p);
                        break;
                    }
                } else {
                    System.out.println(p.val);
                    stack.pop();
                }
            }
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(3);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(13);
        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(14);

        /*
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        */

        FaceBook_PostOrder p = new FaceBook_PostOrder();
        p.postOrder(root);
    }
}
