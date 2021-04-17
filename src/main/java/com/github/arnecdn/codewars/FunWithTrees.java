package com.github.arnecdn.codewars;

public class FunWithTrees {
    static int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = root.value + maxSum(root.left);
        int right = root.value + maxSum(root.right);

        return (left > right) ? left : right;
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
    }
}
