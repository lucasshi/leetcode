package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fzy on 17/10/9.
 */
public class FaceBook_VerticalTraverse {
    HashMap<Integer, List<TreeNode>> treeList = new HashMap<>();
    private int minLevel = Integer.MAX_VALUE;
    private int maxLevel = Integer.MIN_VALUE;

    public void verticalTraverse(TreeNode root, int level) {
        if (root == null)
            return;

        if (!treeList.containsKey(level)) {
            treeList.put(level, new ArrayList<>());
        }
        treeList.get(level).add(root);

        verticalTraverse(root.left, level - 1);
        verticalTraverse(root.right, level + 1);
    }

    public static void main(String[] args) {

    }

}
