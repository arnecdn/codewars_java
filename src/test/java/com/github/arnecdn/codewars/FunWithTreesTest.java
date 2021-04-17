package com.github.arnecdn.codewars;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import static com.github.arnecdn.codewars.FunWithTrees.maxSum;

import org.junit.Test;

import com.github.arnecdn.codewars.FunWithTrees.TreeNode;

public class FunWithTreesTest {
    /**
     * null
     */
    @Test
    public void maxSumInNullTree() {
        TreeNode root = null;
        assertThat(maxSum(root), is(0));
    }

    /**
     *      5
     *    /   \
     *  -22    11
     *  / \    / \
     * 9  50  9   2
     */
    @Test
    public void maxSumInPerfectTree() {
        TreeNode left = TreeNode.leaf(-22).withLeaves(9, 50);
        TreeNode right = TreeNode.leaf(11).withLeaves(9, 2);
        TreeNode root = TreeNode.join(5, left, right);
        assertThat(maxSum(root), is(33));
    }

}