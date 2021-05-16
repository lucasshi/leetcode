package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P1082_balanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        return helper(0, inorderList.size() - 1, inorderList);
    }

    private TreeNode helper(int start, int end, List<Integer> inorderList) {
        if (start == end)
            return new TreeNode(inorderList.get(start));
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(inorderList.get(mid));
        root.left = helper(start, mid - 1, inorderList);
        root.right = helper(mid + 1, end, inorderList);
        return root;
    }

    private void inorder(TreeNode root, List<Integer> inorderList) {
        if (root == null)
            return;
        inorder(root.left, inorderList);
        inorderList.add(root.val);
        inorder(root.right, inorderList);
    }

    public static void main(String[] args) {
        P1082_balanceBST p1082_balanceBST = new P1082_balanceBST();
        List<Integer> integerList = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toList());
        TreeNode root = p1082_balanceBST.helper(0, integerList.size() - 1, integerList);
        System.out.println("wefwef");
    }
}
