package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
}
