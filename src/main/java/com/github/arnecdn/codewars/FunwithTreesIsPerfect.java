package com.github.arnecdn.codewars;

public class FunwithTreesIsPerfect {

    public static boolean isPerfect(TreeNode root) {
        if (root == null) {
            return true;
        }
        int height = calculateHeigth(root);
        return isBalanced(root, height, 0);
    }

    private static int calculateHeigth(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + calculateHeigth(root.left);
        int right = 1 + calculateHeigth(root.right);

        return Math.max(left, right);
    }

    private static boolean isBalanced(TreeNode root, int height, int rootHeight) {
        if (root == null) {
            return height == rootHeight;
        }

        boolean left = isBalanced(root.left, height, rootHeight + 1);
        boolean right = isBalanced(root.right, height, rootHeight + 1);
        return (left && right);
    }

    static class TreeNode {

        TreeNode left;
        TreeNode right;

        static TreeNode leaf() {
            return new TreeNode();
        }

        static TreeNode join(TreeNode left, TreeNode right) {
            return new TreeNode().withChildren(left, right);
        }

        TreeNode withLeft(TreeNode left) {
            this.left = left;
            return this;
        }

        TreeNode withRight(TreeNode right) {
            this.right = right;
            return this;
        }

        TreeNode withChildren(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
            return this;
        }

        TreeNode withLeftLeaf() {
            return withLeft(leaf());
        }

        TreeNode withRightLeaf() {
            return withRight(leaf());
        }

        TreeNode withLeaves() {
            return withChildren(leaf(), leaf());
        }
    }
}
