package com.tentcent.lucasshi.facebook;

import com.tencent.lucasshi.NestedInteger;

import java.util.Stack;

/**
 * Created by fzy on 17/10/3.
 */
public class FaceBook_FlattenNest {
    private NestedInteger p;
    private Stack<NestedInteger> stack;

    public FaceBook_FlattenNest(NestedInteger root) {
        stack = new Stack<>();
        p = root;

        while (!p.isInteger()) {
            for (int i = p.getList().size() - 1; i >= 0; i--) {
                stack.push(p.getList().get(i));
            }
            // 获取第一个
            p = stack.pop();
        }
    }

    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        }

        p = stack.pop();
        while (!p.isInteger()) {
            for (int i = p.getList().size() - 1; i >= 0; i--) {
                stack.push(p.getList().get(i));
            }
            p = stack.pop();
        }
        return true;
    }

    public int next() {
        return p.getInteger();
    }

    public static void main(String[] args) {

    }
}
