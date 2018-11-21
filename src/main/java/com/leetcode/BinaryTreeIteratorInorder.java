package com.leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTreeIteratorInorder implements Iterator<Integer> {

    Deque<TreeNode> stack = new ArrayDeque<>();

    public BinaryTreeIteratorInorder(TreeNode cur) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
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
        int result = cur.val;
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return result;
    }
}
