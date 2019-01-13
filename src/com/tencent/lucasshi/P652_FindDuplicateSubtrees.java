package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class P652_FindDuplicateSubtrees {
    public HashMap<String, TreeNode> duplicate = new HashMap<>();
    public HashSet<String> codeResult = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        List<TreeNode> treeList = new ArrayList<>();
        for (String code : codeResult) {
            treeList.add(duplicate.get(code));
        }
        return treeList;
    }

    public String helper(TreeNode root) {
        if (root == null)
            return "#,";
        String ls = helper(root.left);
        String rs = helper(root.right);
        String code = root.val + "," + ls + rs;
        if (duplicate.containsKey(code)) {
            codeResult.add(code);
        } else {
            duplicate.put(code, root);
        }
        return code;
    }
}
