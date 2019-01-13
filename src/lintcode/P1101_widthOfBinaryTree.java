package lintcode;

import com.tencent.lucasshi.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class P1101_widthOfBinaryTree {
    public HashMap<Integer, int[]> levelData = new HashMap<>();
    public HashMap<Integer, Integer> countData = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        levelData = new HashMap<>();
        helper(root, 0, 0);
        int width = 1;
        for (Integer key : levelData.keySet()) {
            if (countData.get(key) < 2)
                continue;
            width = Math.max(width, levelData.get(key)[1] - levelData.get(key)[0] + 1);
            System.out.println(levelData.get(key)[0] + " " + levelData.get(key)[1]);
        }
        return width;
    }

    public void helper(TreeNode root, int hLevel, int vLevel) {
        if (root == null)
            return;
        if (!levelData.containsKey(hLevel)) {
            levelData.put(hLevel, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            countData.put(hLevel, 0);
        }
        levelData.get(hLevel)[0] = Math.min(vLevel, levelData.get(hLevel)[0]);
        levelData.get(hLevel)[1] = Math.max(vLevel, levelData.get(hLevel)[1]);
        countData.put(hLevel, countData.get(hLevel) + 1);

        helper(root.left, hLevel + 1, vLevel * 2);
        helper(root.right, hLevel + 1, vLevel * 2 + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.right.left = new TreeNode(5);
        P1101_widthOfBinaryTree p = new P1101_widthOfBinaryTree();
        p.widthOfBinaryTree(root);
    }
}
