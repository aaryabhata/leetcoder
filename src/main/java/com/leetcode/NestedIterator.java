package com.leetcode;

import com.leetcode.common.NestedInteger;

import java.util.*;


public class NestedIterator implements Iterator<Integer> {

    Deque<NestedInteger> stack;

    NestedIterator(List<NestedInteger> nestedIntegerList) {
        stack = new ArrayDeque<>();
        nestedIntegerList.forEach(stack::push);
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger peek = stack.peek();
            if (peek.isInteger()) return true;
            stack.pop().getList().forEach(stack::push);
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public void remove() {

    }
}
