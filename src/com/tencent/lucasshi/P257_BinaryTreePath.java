package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/9/17.
 */
public class P257_BinaryTreePath {
    public List<String> results = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return results;
        }
        buildPaths(root, "");
        return results;
    }

    public void buildPaths(TreeNode root, String path) {
        if (path.equals("")) {
            path = "" + root.val;
        } else {
            path = path + "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            results.add(path);
            return;
        }

        if (root.left != null) {
            buildPaths(root.left, path);
        }

        if (root.right != null) {
            buildPaths(root.right, path);
        }
    }

}
