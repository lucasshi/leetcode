package com.tencent.lucasshi;

import java.util.*;

/**
 * Created by fzy on 17/9/13.
 */
public class P314_BinaryTreeVerticalOrder {
    private TreeMap<Integer, List<Integer>> orders = new TreeMap<>();

    public List<List<Integer>> BinaryTreeVerticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : orders.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public void buildOrderMap(TreeNode root, int verticalOrder) {
        if (root == null)
            return;
        // do
        if (!orders.containsKey(verticalOrder)) {
            orders.put(verticalOrder, new ArrayList<>());
        }

        orders.get(verticalOrder).add(root.val);
        buildOrderMap(root.left, verticalOrder - 1);
        buildOrderMap(root.right, verticalOrder + 1);
    }
}
