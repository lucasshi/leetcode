package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by fzy on 17/4/6.
 */
public class P71_SimplifyPath {
    public static String simplifyPath(String path) {
        String[] segment = path.split("/");
        Stack<String> stack = new Stack<>();

        // segment
        for (int i = 0; i < segment.length; i++) {
            if (segment[i].equals("") || segment[i].equals(".")) {
                continue;
            } else if (segment[i].equals("..")) {
                if (!stack.empty())
                    stack.pop();
            } else {
                stack.push(segment[i]);
            }
        }

        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        String path = "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
        System.out.println(P71_SimplifyPath.simplifyPath(path));
    }
}
