package com.github.arnecdn.codewars;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static com.github.arnecdn.codewars.FunwithTreesIsPerfect.isPerfect;

import org.junit.Test;

import com.github.arnecdn.codewars.FunwithTreesIsPerfect.TreeNode;

public class FunwithTreesIsPerfectTest {

    /**
     * null
     */
    @Test
    public void testNullTree() {
        TreeNode root = null;
        assertThat("null tree should be perfect", isPerfect(root), is(true));
    }

    /**
     * 0
     * / \
     * 0   0
     */
    @Test
    public void testFullOneLevelTree() {
        TreeNode root = TreeNode.leaf().withLeaves();
        assertThat("root with two leaves should be perfect", isPerfect(root), is(true));
    }

    /**
     * 0
     * /
     * 0
     */
    @Test
    public void testOneChildTree() {
        TreeNode root = TreeNode.leaf().withLeftLeaf();
        assertThat("root with single leaf should not be perfect", isPerfect(root), is(false));
    }

    @Test
    public void testChildTree2() {
        TreeNode root = TreeNode.leaf()
            .withLeft(TreeNode.leaf()
                .withLeft(TreeNode.leaf()
                ))
            .withRight(TreeNode.leaf()
                .withRight(
                    TreeNode.leaf()

                )
            );
        assertThat("root with single leaf should not be perfect", isPerfect(root), is(false));
    }

    @Test
    public void testChildTree3() {
        TreeNode root = TreeNode.leaf()
            .withLeft(TreeNode.leaf()
                .withLeft(TreeNode.leaf())
                .withRight(TreeNode.leaf()))
            .withRight(TreeNode.leaf()
            );
        assertThat("root with single leaf should not be perfect", isPerfect(root), is(false));
    }
}