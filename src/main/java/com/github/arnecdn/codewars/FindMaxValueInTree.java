package com.github.arnecdn.codewars;

public class FindMaxValueInTree {
    static int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = findMax(root.left);
        int max = (root.value > left) ? root.value : left;

        int right = findMax(root.right);
        return  (max > right) ? max : right;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        private TreeNode(final int value) {
            this.value = value;
        }

        static TreeNode leaf(int r) {
            return new TreeNode(r);
        }

        public static TreeNode join(final int i, final TreeNode l, final TreeNode r) {
            TreeNode node = new TreeNode(i);
            node.left = l;
            node.right = r;
            return node;
        }

        TreeNode withLeaves(int l, int r) {
            this.left = TreeNode.leaf(l);
            this.right = TreeNode.leaf(r);
            return this;
        }

        public TreeNode withLeftLeaf(final int i) {
            return new TreeNode(Integer.MIN_VALUE).withLeaves(i, Integer.MIN_VALUE);
        }
    }
}
