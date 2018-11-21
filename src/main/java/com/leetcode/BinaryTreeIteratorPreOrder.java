package com.leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTreeIteratorPreOrder implements Iterator<Integer> {
    Deque<TreeNode> stack = new ArrayDeque<>();

    public BinaryTreeIteratorPreOrder(TreeNode cur) {
        stack.push(cur);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("All nodes have been visited!");
        }

        TreeNode cur = stack.pop();
        if (cur.right != null) {
            stack.push(cur.right);
        }
        if (cur.left != null) {
            stack.push(cur.left);
        }
        return cur.val;
    }
}
