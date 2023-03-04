package com.coding.basic.leetcode.binaryTree;

/***
 * @description:
 * @author: ByrsH
 * @create: 2023/3/4 1:32 PM
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }


    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
