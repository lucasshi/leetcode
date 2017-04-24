package com.tencent.lucasshi;

import java.util.ArrayList;

/**
 * Created by fzy on 17/4/6.
 */
public class P71_SimplifyPath {
    public static String simplifyPath(String path) {
        int index = 0;
        String[] segment = path.split("/");
        String[] paths = new String[segment.length];

        // segment
        for (int i = 0; i < segment.length; i++) {
            if (segment[i].equals("")) {
                continue;
            } else if (segment[i].equals(".")) {
                continue;
            } else if (segment[i].equals("..")) {
                if (index > 0) {
                    index--;
                }
            } else {
                paths[index] = segment[i];
                index++;
            }
        }

        String resultPath = "/";
        for (int i = 0; i < index; i++) {
            if (i == index - 1)
                resultPath += paths[i];
            else
                resultPath += paths[i] + "/";
        }

        return resultPath;
    }

    public static void main(String[] args) {
        String path = "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
        System.out.println(P71_SimplifyPath.simplifyPath(path));
    }
}
