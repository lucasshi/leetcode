package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fzy on 17/7/2.
 */
public class P95_UniqueBinarySearchTrees {
    HashMap<String, List<TreeNode>> cacheResults = new HashMap<>();

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        String key = start + "#" + end;
        if (cacheResults.containsKey(key))
            return cacheResults.get(key);

        ArrayList<TreeNode> results = new ArrayList<>();
        if (start > end) {
            return results;
        }

        if (end == start) {
            results.add(new TreeNode(start));
            cacheResults.put(key, results);
            return results;
        }

        for (int seperator = start; seperator <= end; seperator++) {
            List<TreeNode> leftRoots = generateTrees(start, seperator - 1);
            List<TreeNode> rightRoots = generateTrees(seperator + 1, end);

            if (leftRoots.size() == 0) {
                for (int j = 0; j < rightRoots.size(); j++) {
                    TreeNode root = new TreeNode(seperator);
                    root.left = null;
                    root.right = rightRoots.get(j);
                    results.add(root);
                }
                continue;
            }

            if (rightRoots.size() == 0) {
                for (int j = 0; j < leftRoots.size(); j++) {
                    TreeNode root = new TreeNode(seperator);
                    root.right = null;
                    root.left = leftRoots.get(j);
                    results.add(root);
                }
                continue;
            }


            for (int i = 0; i < leftRoots.size(); i++) {
                for (int j = 0; j < rightRoots.size(); j++) {
                    TreeNode root = new TreeNode(seperator);
                    root.left = leftRoots.get(i);
                    root.right = rightRoots.get(j);

                    results.add(root);
                }
            }
        }

        cacheResults.put(key, results);
        return results;
    }

    public static void main(String[] args) {
        P95_UniqueBinarySearchTrees p95_uniqueBinarySearchTrees = new P95_UniqueBinarySearchTrees();
        System.out.println(p95_uniqueBinarySearchTrees.generateTrees(0).size());
    }
}
