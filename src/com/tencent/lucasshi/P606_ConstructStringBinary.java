package com.tencent.lucasshi;

/**
 * Created by fzy on 17/9/20.
 */
public class P606_ConstructStringBinary {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left.length() == 0 && right.length() == 0) {
            left = right = "";
        } else if (right.length() == 0) {
            right = "";
            left = "(" + left + ")";
        } else {
            left = "(" + left + ")";
            right = "(" + right + ")";
        }


        return t.val + left + right;
    }
}
