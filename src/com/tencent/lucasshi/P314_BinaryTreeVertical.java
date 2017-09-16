package com.tencent.lucasshi;


import java.util.*;

/**
 * Created by fzy on 17/9/16.
 */
public class P314_BinaryTreeVertical {
    public HashMap<Integer, List<Integer>> verticalMaps = new HashMap<>();
    private int minLevel = 0;
    private int maxLevel = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        buildVerticalMap(root, 0);
        for (int i = minLevel; i <= maxLevel; i++) {
            if (verticalMaps.get(i) != null) {
                result.add(verticalMaps.get(i));
            }
        }

        return result;
    }

    public void buildVerticalMap(TreeNode root, int level) {
        if (root == null)
            return;

        minLevel = Math.min(minLevel, level);
        maxLevel = Math.max(maxLevel, level);

        if (!verticalMaps.containsKey(level)) {
            verticalMaps.put(level, new ArrayList<>());
        }

        verticalMaps.get(level).add(root.val);
        buildVerticalMap(root.left, level - 1);
        buildVerticalMap(root.right, level + 1);
    }

    class NodeInfo {
        public int val;
        public int level;

        public NodeInfo(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }


    public void buildVerticlaMapV2(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<NodeInfo> infoQueue = new LinkedList<>();
        nodeQueue.add(root);
        infoQueue.add(new NodeInfo(root.val, 0));

        while (!nodeQueue.isEmpty()) {
            TreeNode pNode = nodeQueue.poll();
            NodeInfo info = infoQueue.poll();

            // vertical map
            if (!verticalMaps.containsKey(info.level)) {
                verticalMaps.put(info.level, new ArrayList<>());
            }

            verticalMaps.get(info.level).add(info.val);
            minLevel = Math.min(minLevel, info.level);
            maxLevel = Math.min(maxLevel, info.level);

            if (pNode.left != null) {
                nodeQueue.add(pNode.left);
                infoQueue.add(new NodeInfo(pNode.left.val, info.level - 1));
            }

            if (pNode.right != null) {
                nodeQueue.add(pNode.right);
                infoQueue.add(new NodeInfo(pNode.right.val, info.level + 1));
            }
        }
    }
}
