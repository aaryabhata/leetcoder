package com.leetcode;


import com.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTreeIteratorPostOrder implements Iterator<Integer> {

    Deque<TreeNode> stack = new ArrayDeque<>();

    public BinaryTreeIteratorPostOrder(TreeNode cur) {
        findNextLeaf(cur);
    }

    private void findNextLeaf(TreeNode cur) {
        while (cur != null) {
            stack.push(cur);
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
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

        TreeNode res = stack.pop();
        if (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (res == top.left) {
                findNextLeaf(top.right); // find next leaf in right sub-tree
            }
        }
        return res.val;
    }
}
