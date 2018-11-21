package com.leetcode;

import com.leetcode.common.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer lowerBound, Integer upperBound) {
        if (root == null) return true;

        if (lowerBound != null && root.val <= lowerBound) return false;
        if (upperBound != null && root.val >= upperBound) return false;

        boolean leftBST = isValidBST(root.left, lowerBound, root.val);
        boolean rightBST = isValidBST(root.right, root.val, upperBound);

        return leftBST && rightBST;
    }
}
