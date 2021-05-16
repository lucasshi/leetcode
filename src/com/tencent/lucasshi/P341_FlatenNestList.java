package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by fzy on 17/9/16.
 */
class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--)
            stack.push(nestedList.get(i));
    }

    @Override
    public Integer next() {

        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty() && stack.peek().isInteger() == false) {
            NestedInteger top = stack.pop();
            for (int i = top.getList().size() - 1; i >= 0; i--)
                stack.push(top.getList().get(i));
        }

        return !stack.empty();
    }
}

public class P341_FlatenNestList {
    public static void main(String[] args) {
        NestedInteger n1 = new NestedInteger();
        List<NestedInteger> list1 = new ArrayList<NestedInteger>();
        list1.add(new NestedInteger(1));
        list1.add(new NestedInteger(1));
        n1.setList(list1);

        NestedInteger n2 = new NestedInteger(2);
        NestedInteger n3 = new NestedInteger();
        list1 = new ArrayList<>();
        list1.add(new NestedInteger(1));
        list1.add(new NestedInteger(1));
        n3.setList(list1);

        List<NestedInteger> input = new ArrayList<>();
        input.add(n1);
        input.add(n2);
        input.add(n3);

        //input = new ArrayList<>();

        NestedIterator iterator = new NestedIterator(input);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
