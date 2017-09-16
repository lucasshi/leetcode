package com.tencent.lucasshi;

import java.util.List;

/**
 * Created by fzy on 17/9/16.
 */
public class NestedInteger {
    public boolean isInteger() {
        return nestedIntegerList == null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return integer;
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return nestedIntegerList;
    }

    public void setList(List<NestedInteger> nestedIntegerList) {
        this.nestedIntegerList = nestedIntegerList;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public NestedInteger() {}
    public NestedInteger(int integer) {
        this.integer = integer;
    }

    private int integer;
    private List<NestedInteger> nestedIntegerList;

}
