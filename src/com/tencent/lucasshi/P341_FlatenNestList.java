package com.tencent.lucasshi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by fzy on 17/9/16.
 */
class NestedIterator implements Iterator<Integer> {
    private ArrayList<Integer> intList = new ArrayList<>();
    private int index = 0;

    public List<Integer> parseInteger(NestedInteger ni) {
        ArrayList<Integer> result = new ArrayList<>();
        if (ni.isInteger()) {
            result.add(ni.getInteger());
            return result;
        }

        for (int i = 0; i < ni.getList().size(); i++) {
            List<Integer> subResult =
                    parseInteger(ni.getList().get(i));
            result.addAll(subResult);
        }

        return result;
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            intList.addAll(parseInteger(nestedList.get(i)));
        }
    }

    @Override
    public Integer next() {

        return intList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < intList.size();
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
