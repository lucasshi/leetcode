package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by fzy on 17/9/21.
 */
public class P536_ConstructBinaryTreeString {
    public static final int TYPE_NODE = 1;
    public static final int TYPE_BRACKET = 2;

    public TreeNode str2String(String s) {
        if (s.length() == 2)
            return null;

        s = s.substring(1, s.length() - 1);
        String curs = "";
        int lbindex = 0;
        for (lbindex = 0; lbindex < s.length() && s.charAt(lbindex) != '('; lbindex++) {
            curs += s.charAt(lbindex);
        }

        TreeNode root = new TreeNode(Integer.valueOf(curs));

        List<String> substrings = new ArrayList<>();
        int lsum = 0;
        int rsum = 0;
        String nodeString = "";
        for (int i = lbindex; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lsum += 1;
            } else if (s.charAt(i) == ')') {
                rsum += 1;
            }
            nodeString += s.charAt(i);
            if (lsum == rsum) {
                substrings.add(nodeString);
                nodeString = "";
            }
        }

        if (substrings.size() == 0)
            return root;

        if (substrings.size() >= 1)
            root.left = str2String(substrings.get(0));

        if (substrings.size() >= 2)
            root.right = str2String(substrings.get(1));

        return root;
    }


    public static void main(String[] args) {
        P536_ConstructBinaryTreeString p = new P536_ConstructBinaryTreeString();
        //p.str2treeV1("4(2(3)(1))(6(5))");

        String s = "(2(3)(1))";
        System.out.println(s.substring(1, s.length() - 1));
        String s1 = "(4(2(3)(1))(6(5)))";


        TreeNode root = p.str2String(s);
        TreeNode root2 = p.str2String(s1);


    }
}
