package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/10/14.
 */
public class FaceBook_FindPath {
    public TreeNode FindPath(TreeNode rootA, TreeNode rootB, TreeNode a) {
        return null;
    }

    public boolean getPath(TreeNode root, TreeNode a, List<Integer> path) {
        if (root == a) {
            path.add(a.val);
            return true;
        }

        if (root == null) {
            return false;
        }

        path.add(root.val);
        if (getPath(root.left, a, path)) {
            return true;
        }


        if (getPath(root.right, a, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public TreeNode getResult(TreeNode rootA, TreeNode rootB, TreeNode a) {
        if (rootA == null)
            return null;

        if (rootA == a)
            return rootB;

        TreeNode leftResult = getResult(rootA.left, rootB.left, a);
        if (leftResult != null) {
            return leftResult;
        }

        TreeNode rightResult = getResult(rootA.right, rootB.right, a);
        if (rightResult != null) {
            return rightResult;
        }

        return null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(11);

        List<Integer> paths = new ArrayList<>();
        FaceBook_FindPath p = new FaceBook_FindPath();
        //System.out.println(p.getPath(root, root.left.right, paths));
        //System.out.println(paths);

        System.out.println(p.getResult(root, root, root.left.right).val);
    }
}
