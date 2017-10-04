package com.tentcent.lucasshi.facebook;

import java.util.Stack;

/**
 * Created by fzy on 17/10/2.
 */
public class FaceBook_SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> pathStack = new Stack<>();
        String[] splitPath = path.split("/");

        //
        for (int i = 0; i < splitPath.length; i++) {
            String s = splitPath[i];
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!pathStack.empty()) {
                    pathStack.pop();
                }
            } else {
                pathStack.push(s);
            }
        }

        String output = "/";
        for (int i = 0; i < pathStack.size(); i++) {
            output += pathStack.get(i) + "/";
        }

        return output.substring(0, output.length() - 1);
    }

    public static void main(String[] args) {
        FaceBook_SimplifyPath p = new FaceBook_SimplifyPath();
        System.out.println(p.simplifyPath("/a/./b/../../c/"));
    }
}
