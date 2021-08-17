package com.tencent.lucasshi;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class P1249_minRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> indexStack = new Stack<>();
        Set<Integer> removeIndex = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                indexStack.push(i);
            } else if (s.charAt(i) == ')') {
                if (indexStack.empty()) {
                    removeIndex.add(i);
                } else {
                    indexStack.pop();
                }
            }
        }

        removeIndex.addAll(indexStack);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (removeIndex.contains(i))
                continue;
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
