package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P1110_delNodes {
    List<TreeNode> result;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        result = new ArrayList<>();
        Set<Integer> toDeletes = Arrays.stream(to_delete)
                .mapToObj(v -> Integer.valueOf(v))
                .collect(Collectors.toSet());
        helper(null, root, toDeletes);
        return result;
    }

    public void helper(TreeNode father, TreeNode pnode, Set<Integer> toDeletes) {
        if (pnode == null)
            return;

        // delete the node
        if (toDeletes.contains(pnode.val)) {
            if (father != null) {
                father.left = father.left == pnode? null : father.left;
                father.right = father.right == pnode? null : father.right;
            }

            helper(null, pnode.left, toDeletes);
            helper(null, pnode.right, toDeletes);
        } else {
            if (father == null) {
                result.add(pnode);
            }
            helper(pnode, pnode.left, toDeletes);
            helper(pnode, pnode.right, toDeletes);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int[] toDeletes = {3, 5};
        P1110_delNodes p1110_delNodes = new P1110_delNodes();
        p1110_delNodes.delNodes(root, toDeletes);
    }
}
