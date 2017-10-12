package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/10/11.
 */
public class FaceBook_PathSum2 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        helper(path, root, sum);
        return result;
    }

    public void helper(List<Integer> path, TreeNode root, int sum) {
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                ArrayList<Integer> subres = new ArrayList<>(path);
                result.add(subres);
            }
        }

        if (root.left != null) {
            helper(path, root.left, sum - root.val);
        }

        if (root.right != null) {
            helper(path, root.right, sum - root.val);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        FaceBook_PathSum2 p = new FaceBook_PathSum2();
        List<List<Integer>> result = p.pathSum(root, 22);
        System.out.println(result);
    }
}
