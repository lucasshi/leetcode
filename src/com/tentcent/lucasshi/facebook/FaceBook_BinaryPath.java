package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_BinaryPath {
    private HashSet<String> paths = new HashSet<>();

    public HashSet<String> binaryTreePaths(TreeNode root) {
        String path = "";
        buildPaths(root, path);
        return paths;
    }

    public void buildPaths(TreeNode root, String path) {
        if (path == "") {
            path += root.val;
        } else {
            path += "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            paths.add(path);
            System.out.println(path);
            return;
        }

        if (root.left != null) {
            buildPaths(root.left, path);
        }

        if (root.right != null) {
            buildPaths(root.right, path);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        //root.left.right = new TreeNode(1);

        FaceBook_BinaryPath p = new FaceBook_BinaryPath();
        p.binaryTreePaths(root);
    }
}
