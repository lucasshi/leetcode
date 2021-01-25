package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/9/17.
 */
public class P285_SuccessorNode {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode cursor = p.right;
            while (cursor.left != null) {
                cursor = cursor.left;
            }
            return cursor;
        }

        List<TreeNode> paths = getPath(root, p);
        for (int i = 1; i < paths.size(); i++) {
            if (paths.get(i).left == paths.get(i - 1)) {
                return paths.get(i);
            }
        }

        return null;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode p) {
        if (root == p) {
            List<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(p);
            return nodeList;
        } else if (root == null) {
            return null;
        }

        List<TreeNode> leftPath = getPath(root.left, p);
        if (leftPath != null) {
            leftPath.add(root);
            return leftPath;
        }

        List<TreeNode> rightPath = getPath(root.right, p);
        if (rightPath != null) {
            rightPath.add(root);
            return rightPath;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        P285_SuccessorNode p = new P285_SuccessorNode();
        p.inorderSuccessor(root, root.right);
    }
}
