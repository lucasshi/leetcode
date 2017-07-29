package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy on 17/7/2.
 */
public class P95_UniqueBinarySearchTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 1) {
            ArrayList<TreeNode> result = new ArrayList<>();
            result.add(new TreeNode(1));
            return result;
        }

        return null;
    }
}
